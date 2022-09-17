package mpdgr.airplanetracker.web.apiclients.aeroapi;

import mpdgr.airplanetracker.web.apiclients.aeroapi.dto.FlightDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.Optional;

public class AeroApiClientTest {
    String apiKey = "";
    AeroApiClient aeroApiClient = new AeroApiClient();

    @Test
    @Disabled
    void getFlightDetailsShouldReturnValidDto(){
        //given
        String identValid = "CMB449";
        aeroApiClient.apiKey = apiKey;
        System.out.println(this.apiKey);
        System.out.println(aeroApiClient.headerParam);
        Optional<FlightDto> flightDto = aeroApiClient.getFlightDetails(identValid);
        System.out.println(flightDto);
        //then
        Assertions.assertNotNull(flightDto);
    }
}
