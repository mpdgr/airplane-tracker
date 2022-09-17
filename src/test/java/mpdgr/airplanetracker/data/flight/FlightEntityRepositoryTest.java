package mpdgr.airplanetracker.data.flight;

import mpdgr.airplanetracker.domain.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;

@RunWith( SpringRunner.class )
@SpringBootTest

class FlightEntityRepositoryTest {
    @Autowired
    FlightEntityRepository repository;
    @Test
    void getAll() {
        List<Flight> empty = repository.getAll().stream()
                .filter(f -> f.getAircraft().getReg().equals("HL-8046"))
                .collect(Collectors.toList());

        List<Flight> notEmpty = repository.getAll().stream()
                .filter(f -> f.getAircraft().getReg().equals("N415MC"))
                .collect(Collectors.toList());

        Assertions.assertTrue(empty.size() == 0);
        Assertions.assertTrue(notEmpty.size() != 0);

    }
}