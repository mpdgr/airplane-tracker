package mpdgr.airplanetracker.data.flight;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import mpdgr.airplanetracker.domain.model.Flight;
import mpdgr.airplanetracker.domain.ports.data.FlightRepository;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@CommonsLog
public class FlightEntityRepository implements FlightRepository {
    private final FlightJpaRepository flightJpaRepository;
    private final FlightEntityMapper mapper;

    @Override
    public void saveFlight(Flight flight){
        FlightEntity flightEntity = mapper.flightToFlightEntity(flight);
        List<FlightEntity> listed = flightJpaRepository.findAll().stream()
                .filter(flightEntity::isSame)
                .collect(Collectors.toList());
        if (listed.size() > 1){
            log.error("verify data for UUID " + flight.getUuid().toString());
        }
        if (listed.isEmpty()){
            flightJpaRepository.save(flightEntity);
        } else {
            listed.forEach(f -> flightJpaRepository.updateUuidCol(f.getId(), flight.getUuid().toString()));
        }
    }

    @Override
    public void updateLastObservation(UUID uuid, Timestamp timestamp) {
        flightJpaRepository.updateLastObservationCol(uuid.toString(), timestamp);
    }

    @Override
    public Optional<Flight> findById(int id) {
        Optional<FlightEntity> flightEntity = flightJpaRepository.findById(id);
        return flightEntity.isPresent() ?
                Optional.of(mapper.flightEntityToFlight(flightEntity.get())) : Optional.empty();
    }

    @Override
    public List<Flight> getAll() {
        return flightJpaRepository.findAll().stream()
                .filter(this::entryVerified)
                .map(mapper::flightEntityToFlight)
                .collect(Collectors.toList());
    }

    public boolean entryVerified (FlightEntity f){
        if (!f.getAircraft().getTypeName().startsWith("Boeing 747")){
            String errorEntry = f.getAircraft().getHexIcao();
            //log.error("DB entry error: hex " + errorEntry);
            return false;
        }
        return true;
    }
}
