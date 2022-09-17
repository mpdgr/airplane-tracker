package mpdgr.airplanetracker.web.apiclients.opensky.dto;

import mpdgr.airplanetracker.domain.model.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    public int objectToIntMapper(Object o) {
        try {
            return o == null ? 0 : (int) o;
        } catch (ClassCastException e) {
            return 0;
        }
    }

    public double objectToDoubleMapper(Object o) {
        try {
            return o == null ? 0 : (double) o;
        } catch (ClassCastException e) {
            return 0;
        }
    }

    public Flight dtoToFlight(Object[] flightRaw) {
        String icao24 = String.valueOf(flightRaw[0]);
        String callsign = String.valueOf(flightRaw[1]);
        String originCountry = String.valueOf(flightRaw[2]);
        int timePosition = objectToIntMapper(flightRaw[3]);
        int lastContact = objectToIntMapper(flightRaw[4]);
        double longitude = objectToDoubleMapper(flightRaw[5]);
        double latitude = objectToDoubleMapper(flightRaw[6]);
        double baroAltitude = objectToDoubleMapper(flightRaw[7]);
        boolean onGround = (boolean) flightRaw[8];
        double velocity = objectToDoubleMapper(flightRaw[9]);
        double trueTrack = objectToDoubleMapper(flightRaw[10]);
        double verticalRate = objectToDoubleMapper(flightRaw[11]);
        int[] sensors = (int[]) flightRaw[12];
        double geoAltitude = objectToDoubleMapper(flightRaw[13]);
        String squawk = String.valueOf(flightRaw[14]);
        boolean spi = (boolean) flightRaw[15];
        int positionSource = objectToIntMapper(flightRaw[16]);

        return new Flight(icao24, callsign, originCountry);
    }
}
