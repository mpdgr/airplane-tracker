package mpdgr.airplanetracker.data.aircraft;

import lombok.*;
import org.springframework.lang.NonNull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Aircraft")
@Table(name = "Aircrafts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class AircraftEntity {

    private String reg;
    private boolean active;
    private String serial;
    @Id
    @NonNull
    private String hexIcao;
    private String airlineName;
    private String iataType;
    private String iataCodeShort;
    private String icaoCode;
    private String model;
    private String modelCode;
    private int numSeats;
    private String rolloutDate;
    private String firstFlightDate;
    private String deliveryDate;
    private String registrationDate;
    private String typeName;
    private int numEngines;
    private String engineType;
    private boolean isFreighter;
    private String productionLine;
    private int ageYears;
    private boolean verified;

    @Override
    public String toString() {
        return "Aircraft{" +
                "reg='" + reg + '\'' +
                ", active=" + active +
                ", serial='" + serial + '\'' +
                ", hexIcao='" + hexIcao + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", iataType='" + iataType + '\'' +
                ", iataCodeShort='" + iataCodeShort + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", model='" + model + '\'' +
                ", modelCode='" + modelCode + '\'' +
                '}';
    }
}
