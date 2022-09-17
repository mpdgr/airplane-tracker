package mpdgr.airplanetracker.data.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;

public interface FlightJpaRepository extends JpaRepository<FlightEntity, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE FLIGHTS SET LAST_OBSERVATION = :timeStamp WHERE UUID = :uuid", nativeQuery = true)
    void updateLastObservationCol(@Param("uuid") String uuid,
                                  @Param("timeStamp") Timestamp timestamp);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE FLIGHTS SET UUID = :uuid WHERE ID = :id", nativeQuery = true)
    void updateUuidCol(@Param("id") int id,
                       @Param("uuid") String uuid);
}
