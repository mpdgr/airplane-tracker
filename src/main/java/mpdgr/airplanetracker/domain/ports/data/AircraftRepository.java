package mpdgr.airplanetracker.domain.ports.data;

import mpdgr.airplanetracker.domain.model.Aircraft;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface AircraftRepository {

    Optional<Aircraft> findByIcao24(String icao24);

    List<Aircraft> getAll();

    void saveAircraft(Aircraft aircraft);
}
