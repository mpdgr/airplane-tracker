package mpdgr.airplanetracker.data.flight;

import lombok.Getter;
import lombok.Setter;
import mpdgr.airplanetracker.data.aircraft.AircraftEntity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "Flight")
@Table(name = "Flights")
@Getter
@Setter
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String uuid;

    /* Aircraft data */
    @ManyToOne
    @JoinColumn(name = "aircraft_hex_icao")
    private AircraftEntity aircraft;
    private String icao24;

    /* Flight data */
    private String callsign;
    private String originCountry;

    /* Route data */
    private String originAirport;
    private String destinationAirport;

    /* Spotted */
    private Timestamp spottedDate;
    private Timestamp lastObservation;
    private boolean spottedPl;

    /* isSame - observations refer the same flight if recorded within 20 hours */
    public boolean isSame(FlightEntity f) {
        if (!Objects.equals(icao24, f.icao24)
                || !Objects.equals(callsign, f.callsign)
                || !Objects.equals(originAirport, f.originAirport)
                || !Objects.equals(destinationAirport, f.destinationAirport)
                || spottedDate == null
                || f.getSpottedDate() == null)
            return false;
        return spottedDate.toInstant().toEpochMilli() - f.getSpottedDate().toInstant().toEpochMilli() < 72000_000
                && (spottedDate.toInstant().toEpochMilli() - f.getSpottedDate().toInstant().toEpochMilli()) > -72000_000;
    }
}
