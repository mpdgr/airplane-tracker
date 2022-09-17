package mpdgr.airplanetracker.data.flight;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class FlightEntityTest {

    @Test
    @Disabled
    void isSameReturnsCorrectResult() {
        Timestamp ts1 = new Timestamp(System.currentTimeMillis());
        Timestamp ts2 = new Timestamp(System.currentTimeMillis() - 200_000);
        Timestamp ts3 = new Timestamp(System.currentTimeMillis() + 200_000);
        Timestamp ts4 = new Timestamp(10);
        Timestamp ts5 = new Timestamp(100);
        Timestamp ts6 = new Timestamp(100_000_000);
        FlightEntity fe1 = new FlightEntity();
        FlightEntity fe2 = new FlightEntity();
        FlightEntity fe3 = new FlightEntity();
        FlightEntity fe4 = new FlightEntity();
        FlightEntity fe5 = new FlightEntity();
        FlightEntity fe6 = new FlightEntity();
        fe1.setSpottedDate(ts1);
        fe2.setSpottedDate(ts2);
        fe3.setSpottedDate(ts3);
        fe4.setSpottedDate(ts4);
        fe5.setSpottedDate(ts5);
        fe6.setSpottedDate(ts6);
        //then
        assertTrue(fe1.isSame(fe2));
        assertTrue(fe1.isSame(fe3));
        assertTrue(fe1.isSame(fe3));
        assertFalse(fe1.isSame(fe6));
        assertFalse(fe4.isSame(fe6));
        assertTrue(fe4.isSame(fe5));
    }
}