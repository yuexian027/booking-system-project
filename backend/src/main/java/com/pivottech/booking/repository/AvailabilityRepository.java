package com.pivottech.booking.repository;

import com.pivottech.booking.model.Availability;
import com.pivottech.booking.model.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AvailabilityRepository extends CrudRepository<Availability, Long> {
    @Query(
            value = "SELECT a from Availability a" +
                    "WHERE a.instructor = : instructor AND" +
                    "a.utcStartTime >= : from AND a.utcEndTime < : to"

    )
    List<Availability> findBetween (
            @Param("instructor") Instructor instructor,
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );
    @Query(
            value = "SELECT a from Availability a" +
                    "WHERE a.instructor = : instructor AND" +
                    "a.utcStartTime >= : from AND a.utcEndTime < : to AND" +
                    "a.reservation is Null"

    )
    List<Availability> findAvailableBetween (
            @Param("instructor") Instructor instructor,
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );


}
