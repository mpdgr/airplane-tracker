package mpdgr.airplanetracker.web.restcontrollers.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AircraftDto {
    private String reg;
    private String typeName;
    private String airlineName;
    private String modelCode;
    private String deliveryDate;
}
