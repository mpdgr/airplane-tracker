package mpdgr.airplanetracker.domain.ports.web;

import mpdgr.airplanetracker.domain.model.Flight;

public interface FlightDataProvider {
    Flight updateRouteData(Flight flight);
}
