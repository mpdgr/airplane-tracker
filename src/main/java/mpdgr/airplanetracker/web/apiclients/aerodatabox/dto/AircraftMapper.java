package mpdgr.airplanetracker.web.apiclients.aerodatabox.dto;

import mpdgr.airplanetracker.domain.model.Aircraft;
import org.springframework.stereotype.Component;

@Component
public class AircraftMapper {
    public Aircraft dtoToAircraft(AircraftDto aircraftDto) {
        return new Aircraft(
                aircraftDto.getReg(),
                aircraftDto.isActive(),
                aircraftDto.getSerial(),
                aircraftDto.getHexIcao(),
                aircraftDto.getAirlineName(),
                aircraftDto.getIataType(),
                aircraftDto.getIataCodeShort(),
                aircraftDto.getIcaoCode(),
                aircraftDto.getModel(),
                aircraftDto.getModelCode(),
                aircraftDto.getNumSeats(),
                aircraftDto.getRolloutDate(),
                aircraftDto.getFirstFlightDate(),
                aircraftDto.getDeliveryDate(),
                aircraftDto.getRegistrationDate(),
                aircraftDto.getTypeName(),
                aircraftDto.getNumEngines(),
                aircraftDto.getEngineType(),
                aircraftDto.isFreighter(),
                aircraftDto.getProductionLine(),
                aircraftDto.getAgeYears(),
                aircraftDto.isVerified()
        );
    }
}

