package mpdgr.airplanetracker.domain.model;

import lombok.*;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Flight {

    private int id;
    private UUID uuid;

    /* Aircraft data */
    private Aircraft aircraft;
    private String icao24;

    /* Flight data */
    private String callsign;
    private String originCountry;

    /* Route data */
    private String originAirport;
    private String destinationAirport;

    /* Spotted */
    private Timestamp spottedDate;
    private boolean spottedPl;
    private Timestamp lastObservation;

    {
        spottedDate = new Timestamp(System.currentTimeMillis());
        uuid = UUID.randomUUID();
    }

    public Flight(String icao24, String callsign, String originCountry){
        this.icao24 = icao24;
        this.callsign = callsign;
        this.originCountry = originCountry;
    }

    @Override
    public String toString() {
        return "Flight: " + callsign +
                ", Aircraft: " + aircraft +
                ", Origin country: " + originCountry +
                ", Origin airport: " + originAirport +
                ", Destination airport: " + destinationAirport +
                ", Spotted: " + spottedDate +
               // ", Last observation: " + lastObservation +
                '\n';
    }
}




