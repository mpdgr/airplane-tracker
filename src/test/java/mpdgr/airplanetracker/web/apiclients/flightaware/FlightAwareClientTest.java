package mpdgr.airplanetracker.web.apiclients.flightaware;

import mpdgr.airplanetracker.domain.util.B747Resolver;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

class FlightAwareClientTest {

    @Test
    @Disabled
    void getWebContentTest() {
        FlightAwareClient client = new FlightAwareClient();
        String result = client.getWebContent("CLX6NV");
        B747Resolver resolver = new B747Resolver();
        assertTrue(resolver.containsB747Data(result));
    }
}