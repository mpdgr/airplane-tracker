package mpdgr.airplanetracker.domain.model;

import lombok.*;
import org.springframework.lang.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Aircraft {
    private String reg;
    private boolean active;
    private String serial;
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
        return "reg: " + reg +
                ", hex: " + hexIcao +
                ", airline: " + airlineName +
                ", model: " + modelCode
                ;
    }
}
