package mpdgr.airplanetracker.web.apiclients.aeroapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Data
public class FlightDto {
    @JsonProperty private String ident;
    @JsonProperty private String ident_icao;
    @JsonProperty private String ident_iata;
    @JsonProperty private String fa_flight_id;
    @JsonProperty private String operator;
    @JsonProperty private String operator_icao;
    @JsonProperty private String operator_iata;
    @JsonProperty private String flight_number;
    @JsonProperty private String registration;
    @JsonProperty private String atc_ident;
    @JsonProperty private String inbound_fa_flight_id;
    @JsonProperty private ArrayList<String> codeshares;
    @JsonProperty private ArrayList<String> codeshares_iata;
    @JsonProperty private boolean blocked;
    @JsonProperty private boolean diverted;
    @JsonProperty private boolean cancelled;
    @JsonProperty private boolean position_only;
    @JsonProperty private OriginDto origin;
    @JsonProperty private DestinationDto destination;
    @JsonProperty private int departure_delay;
    @JsonProperty private int arrival_delay;
    @JsonProperty private int filed_ete;
    @JsonProperty private String scheduled_out;
    @JsonProperty private String estimated_out;
    @JsonProperty private String actual_out;
    @JsonProperty private String scheduled_off;
    @JsonProperty private String estimated_off;
    @JsonProperty private String actual_off;
    @JsonProperty private String scheduled_on;
    @JsonProperty private String estimated_on;
    @JsonProperty private String actual_on;
    @JsonProperty private String scheduled_in;
    @JsonProperty private String estimated_in;
    @JsonProperty private String actual_in;
    @JsonProperty private int progress_percent;
    @JsonProperty private String status;
    @JsonProperty private String aircraft_type;
    @JsonProperty private int route_distance;
    @JsonProperty private int filed_airspeed;
    @JsonProperty private int filed_altitude;
    @JsonProperty private String route;
    @JsonProperty private String baggage_claim;
    @JsonProperty private int seats_cabin_business;
    @JsonProperty private int seats_cabin_coach;
    @JsonProperty private int seats_cabin_first;
    @JsonProperty private String gate_origin;
    @JsonProperty private String gate_destination;
    @JsonProperty private String terminal_origin;
    @JsonProperty private String terminal_destination;
    @JsonProperty private String type;
}
