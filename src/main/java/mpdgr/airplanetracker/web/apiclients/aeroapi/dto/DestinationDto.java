package mpdgr.airplanetracker.web.apiclients.aeroapi.dto;

import lombok.Data;

@Data
public class DestinationDto {
    private String code;
    private String code_icao;
    private String code_iata;
    private String code_lid;
    private String airport_info_url;
}
