package mpdgr.airplanetracker.web.apiclients.flightaware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FlightAwareAdapterTest {

    @Mock
    FlightAwareClient flightAwareClient;
    FlightAwareAdapter adapter;

    @BeforeEach
    public void init(){
        adapter = Mockito.spy(new FlightAwareAdapter(flightAwareClient));
    }

    @Test
    void containsTypeIdReturnsCorrectTrue(){
        String input747 = "test\"model\":\"747";
        String typeId = "747";
        assertTrue(adapter.containsTypeId(input747, typeId));
    }

    @Test
    void containsTypeIdReturnsCorrectFalse(){
        String input747 = "test767";
        String typeId = "747";
        assertFalse(adapter.containsTypeId(input747, typeId));
    }
}
