package mpdgr.airplanetracker.data.flight;

import mpdgr.airplanetracker.domain.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FlightEntityMapper {
    FlightEntityMapper INSTANCE = Mappers.getMapper(FlightEntityMapper.class);
    FlightEntity flightToFlightEntity(Flight flight);
    Flight flightEntityToFlight(FlightEntity flightEntity);
}
