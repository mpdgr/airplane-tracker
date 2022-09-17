package mpdgr.airplanetracker.domain.ports.web;

import mpdgr.airplanetracker.domain.config.SearchRange;
import mpdgr.airplanetracker.domain.model.Flight;
import java.util.List;

public interface FlightAreaMonitor {
    void setRange(SearchRange range);
    List<Flight> getFlightsInRange();
}
