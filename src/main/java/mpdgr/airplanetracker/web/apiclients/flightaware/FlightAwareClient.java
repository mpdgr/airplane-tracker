package mpdgr.airplanetracker.web.apiclients.flightaware;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Data
@CommonsLog
public class FlightAwareClient {
    public String getWebContent(String flightNo) {
        RestTemplate faTemplate = new RestTemplate();
        String url = String.format("https://flightaware.com/live/flight/%s", flightNo);
        log.info("FlightAware call");
        return faTemplate.getForObject(url, String.class);
   }
}

