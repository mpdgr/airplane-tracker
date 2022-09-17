package mpdgr.airplanetracker.web.apiclients.flightaware;

import lombok.RequiredArgsConstructor;
import mpdgr.airplanetracker.domain.model.Flight;
import mpdgr.airplanetracker.domain.ports.web.AircraftTypeProvider;
import mpdgr.airplanetracker.domain.config.AircraftType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FlightAwareAdapter implements AircraftTypeProvider {
    private final FlightAwareClient flightAwareClient;

    @Override
    public boolean verifyAircraftType(Flight flight, AircraftType type){
        String flightDataString = flightAwareClient.getWebContent(flight.getCallsign());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return containsTypeId(flightDataString, type.getType());
    }

    public boolean containsTypeId(String webContent, String typeId) {
        return webContent.contains(String.format("\"model\":\"%s", typeId));
    }
}
