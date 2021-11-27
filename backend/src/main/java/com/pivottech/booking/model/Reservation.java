package com.pivottech.booking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Reservation")

@Table(indexes = {
        @Index(
                name = "index_instructor_start_end",
                columnList = "utcStartTime, utcEndTime, student_id",
                unique = true
        )


})
@Data
@Builder()
@AllArgsConstructor
public class Reservation {

   String description;

    @Setter(AccessLevel.NONE)
    Long id;

    @OneToMany(mappedBy = "reservation")
    @JsonManagedReference()
    List<Availability> availabilities;

    @NotNull
    LocalDateTime utcStartTime;

    @NotNull
    LocalDateTime utcEndTime;

    @ManyToOne
    @JoinColumn(name = "student_id")

    @NotNull
    Student student;



}


