package mpdgr.airplanetracker.web.apiclients.opensky;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import mpdgr.airplanetracker.domain.model.Flight;
import mpdgr.airplanetracker.web.apiclients.opensky.dto.FlightMapper;
import mpdgr.airplanetracker.web.apiclients.opensky.dto.FlightsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
@CommonsLog
public class OpenSkyClient {
    @Autowired
    private final FlightMapper resolver;
    private String url;

    public List<Flight> getFlightsInRange() {
        RestTemplate osTemplate = new RestTemplate();
        FlightsDto flightsDto = osTemplate.getForEntity(url, FlightsDto.class).getBody();
        log.info("OpenSky call");

        return flightsDto != null ?
                Arrays.stream(flightsDto.getFlights())
                        .map(resolver::dtoToFlight)
                        .collect(Collectors.toList())
                : List.of();
    }
}