package com.pivottech.booking.repository;
import com.pivottech.booking.model.Reservation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReservationRepository extends PagingAndSortingRepository<Reservation, Long> {
    Page<Reservation> findByDescriptionContaining(String terms, Pageable pageable);
}
