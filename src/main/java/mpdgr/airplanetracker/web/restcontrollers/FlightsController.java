package mpdgr.airplanetracker.web.restcontrollers;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import mpdgr.airplanetracker.domain.config.SearchRange;
import mpdgr.airplanetracker.domain.model.Flight;
import mpdgr.airplanetracker.domain.ports.data.FlightRepository;
import mpdgr.airplanetracker.domain.service.FlightsChecker;
import mpdgr.airplanetracker.web.restcontrollers.config.LogConfig;
import mpdgr.airplanetracker.web.restcontrollers.dto.*;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequiredArgsConstructor
@CommonsLog

public class FlightsController {
    private final FlightsChecker service;
    private final FlightRepository flightRepository;
    private final FlightDtoMapper flightDtoMapper;
    private final LogConfig format;

    @GetMapping(path = "/currentflights")
    List<FlightDto> getFlights(HttpServletRequest request) {
        log.info(format.controllerLog(request, "currentflights"));
        List<String> activeUuids = service.getCurrentFlightsContainer().stream()
                .map(f -> f.getUuid().toString())
                .collect(Collectors.toList());

        return flightRepository.getAll().stream()
                .filter(f -> f.getUuid() != null)
                .filter(f -> activeUuids.contains(f.getUuid().toString()))
                .filter(f -> f.isSpottedPl() || !service.getRange().equals(SearchRange.POLAND))
                .sorted(latestFirst)
                .map(flightDtoMapper::flightToFlightDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/recentflights/{days}")
    ResponseEntity<List<FlightDto>> getRecentFlights(@PathVariable @Min(1) @Max(60) long days,
                                                     HttpServletRequest request) {
        log.info(format.controllerLog(request, "recentflights"));
        return ResponseEntity.ok(flightRepository.getAll().stream()
                .filter(flight -> {
                    return (flight.getLastObservation() != null
                            && flight.getLastObservation()
                            .after(new Timestamp(System.currentTimeMillis() - days * 24 * 3600_000)));
                })
                .filter(f -> f.isSpottedPl() || !service.getRange().equals(SearchRange.POLAND))
                .sorted(latestFirst)
                .map(flightDtoMapper::flightToFlightDto)
                .collect(Collectors.toList())
        );
    }

    @GetMapping(path = "/allflights")
    ResponseEntity<List<FlightDto>> getAllFlights(HttpServletRequest request) {
        log.info(format.controllerLog(request, "allflights"));
        return ResponseEntity.ok(flightRepository.getAll().stream()
                .filter(f -> f.isSpottedPl() || !service.getRange().equals(SearchRange.POLAND))
                .sorted(latestFirst)
                .map(flightDtoMapper::flightToFlightDto)
                .collect(Collectors.toList())
        );
    }
    
    @GetMapping(path = "/log", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody byte[] getLog(HttpServletRequest request) throws IOException {
        log.info(format.controllerLog(request, "log"));
        File logFile = new File("src/main/resources/log/restcontroller.log");
        InputStream stream = new FileInputStream(logFile);
        return IOUtils.toByteArray(stream);
    }

    @GetMapping(path = "/")
    ResponseEntity<String> welcome(HttpServletRequest request) throws IOException {
        log.info(format.controllerLog(request, "/"));
        String welcome =
                """
                        <html>
                            <head>
                                <style>
                                    p {margin: 3px; font-family: monospace;}
                                </style>
                            </head>
                               <body>
                                   <p style = "color: darkcyan;">Airplane tracker endpoints:</p>
                                   <p>GET <b>/currentflights</b> &nbsp&nbsp&nbsp&nbsp&nbsp&nbspreturns current B747 flights in PL airspace</p>
                                   <p>GET <b>/recentflights{1-60}</b> &nbspreturns B747 flights in PL airspace recorded within given nr of days</p>
                                   <p>GET <b>/allflights</b> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspreturns all B747 flights recoded in the database</p>
                               </body>
                        </html>
                """;
        return ResponseEntity.ok(welcome);
    }


    Comparator<Flight> latestFirst = Comparator
            .comparing(Flight::getLastObservation)
            .reversed()
            .thenComparing(Flight::getCallsign);
}