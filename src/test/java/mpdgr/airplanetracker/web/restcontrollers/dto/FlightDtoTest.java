package mpdgr.airplanetracker.web.restcontrollers.dto;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

class FlightDtoTest {

    @Test
    @Disabled
    void getLastObservationShouldReturnLocalTime() {
        FlightDto flightDto = new FlightDto();
        flightDto.setLastObservation(new Timestamp(System.currentTimeMillis()));
        System.out.println(flightDto.getLastObservation());
    }
}