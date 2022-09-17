package mpdgr.airplanetracker.web.apiclients.aerodatabox.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonSerialize
@Data
@Getter
public class AircraftDto {
    private String reg;
    private boolean active;
    private String serial;
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
}
