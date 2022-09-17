package mpdgr.airplanetracker.web.apiclients.aeroapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class FlightsDto {
    @JsonProperty
    private List<FlightDto> flights;
}
