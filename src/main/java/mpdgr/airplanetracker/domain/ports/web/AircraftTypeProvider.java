package mpdgr.airplanetracker.domain.ports.web;

import mpdgr.airplanetracker.domain.model.Flight;
import mpdgr.airplanetracker.domain.config.AircraftType;

public interface AircraftTypeProvider {
    boolean verifyAircraftType(Flight flight, AircraftType type);
}
