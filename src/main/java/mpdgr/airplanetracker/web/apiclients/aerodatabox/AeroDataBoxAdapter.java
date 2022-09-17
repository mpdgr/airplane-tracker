package mpdgr.airplanetracker.web.apiclients.aerodatabox;

import lombok.RequiredArgsConstructor;
import mpdgr.airplanetracker.domain.model.Aircraft;
import mpdgr.airplanetracker.domain.ports.web.AircraftDataProvider;
import mpdgr.airplanetracker.web.apiclients.aerodatabox.dto.AircraftMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AeroDataBoxAdapter implements AircraftDataProvider {
    private final AeroDataBoxClient aeroDataBoxClient;
    private final AircraftMapper mapper;

    @Override
    public Aircraft getAircraftData(String icao24code) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return mapper.dtoToAircraft(aeroDataBoxClient
                                    .getRawAcData(icao24code));
    }
}
