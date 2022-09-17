package mpdgr.airplanetracker.web.restcontrollers.exceptionhandler;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse {
    String message;
    String code;
}
