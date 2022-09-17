package mpdgr.airplanetracker.web.apiclients.opensky;

import lombok.AllArgsConstructor;
import mpdgr.airplanetracker.domain.config.SearchRange;
import mpdgr.airplanetracker.domain.model.Flight;
import mpdgr.airplanetracker.domain.ports.web.FlightAreaMonitor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class OpenSkyAdapter implements FlightAreaMonitor {
    private final OpenSkyClient openSkyClient;
    private final ClientSearchRange clientSearchRange;

    @Override
    public void setRange(SearchRange range) {
        openSkyClient.setUrl(clientSearchRange.getRange(range));
    }

    @Override
    public List<Flight> getFlightsInRange() {
        return openSkyClient.getFlightsInRange();
    }
}
