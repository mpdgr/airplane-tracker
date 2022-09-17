package mpdgr.airplanetracker.domain.ports.web;

import mpdgr.airplanetracker.domain.model.Aircraft;

public interface AircraftDataProvider {
    Aircraft getAircraftData(String icao24code);
}
