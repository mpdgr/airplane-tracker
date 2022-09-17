package mpdgr.airplanetracker.data.aircraft;

import lombok.RequiredArgsConstructor;
import mpdgr.airplanetracker.domain.model.Aircraft;
import mpdgr.airplanetracker.domain.ports.data.AircraftRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AircraftEntityRepository implements AircraftRepository {
    private final AircraftJpaRepository aircraftJpaRepository;
    private final AircraftEntityMapper mapper;

    @Override
    public Optional<Aircraft> findByIcao24(String icao24) {
        Optional<AircraftEntity> aircraftEntity = aircraftJpaRepository.findById(icao24);
        return aircraftEntity.isPresent() ?
                Optional.of(mapper.aircraftEntityToAircraft(aircraftEntity.get())) : Optional.empty();
    }

    @Override
    public List<Aircraft> getAll() {
        return aircraftJpaRepository.findAll().stream()
                .map(mapper::aircraftEntityToAircraft)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAircraft(Aircraft aircraft) {
        AircraftEntity aircraftEntity = mapper.aircraftToAircraftEntity(aircraft);
        aircraftJpaRepository.save(aircraftEntity);
    }
}
