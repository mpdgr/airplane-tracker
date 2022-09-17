package mpdgr.airplanetracker.data.repository;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

import mpdgr.airplanetracker.data.aircraft.AircraftEntity;
import mpdgr.airplanetracker.data.aircraft.AircraftEntityMapper;
import mpdgr.airplanetracker.data.flight.FlightEntity;
import mpdgr.airplanetracker.data.flight.FlightEntityMapper;
import mpdgr.airplanetracker.domain.model.Aircraft;
import mpdgr.airplanetracker.domain.model.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MapperTest {
    @Mock
    AircraftEntityMapper aircraftEntityMapper;
    @Spy
    FlightEntityMapper flightEntityMapper;
    @Spy
    Aircraft aircraft;
    @Spy
    Flight flight;

    @Test
    public void mapAircraftToAircraftEntityShouldReturnValidEntity(){
        aircraft.setHexIcao("test");
        AircraftEntity aircraftEntityResult = aircraftEntityMapper.INSTANCE.aircraftToAircraftEntity(aircraft);
        assertNotNull("mapper is null", flightEntityMapper);
        assertEquals("incorrect aircraft", aircraft.getHexIcao(),"test");
        assertEquals("incorrect flight", aircraftEntityResult.getHexIcao(),"test");
    }

    @Test
    public void mapFlightToFlightEntityShouldReturnEntityWithCorrectAcData(){
        aircraft.setHexIcao("test");
        flight.setAircraft(aircraft);
        FlightEntity flightEntity = flightEntityMapper.INSTANCE.flightToFlightEntity(flight);
        assertEquals("incorrect flight", flight.getAircraft().getHexIcao(),"test");
        assertNotNull("entity is null", flightEntity);
        assertEquals("incorrect flightentity", flightEntity.getAircraft().getHexIcao(),"test");
    }
}
