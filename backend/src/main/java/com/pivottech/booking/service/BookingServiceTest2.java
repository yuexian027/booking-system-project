//package com.pivottech.booking.service;
//import com.pivottech.booking.model.Reservation;
//import com.pivottech.booking.repository.ReservationRepository;
//import org.joda.time.DateTime;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import java.util.Optional;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//    @ExtendWith(MockitoExtension.class)
//    class BookingServiceTest2 {
//
//        @Mock
//        ReservationRepository mockReservationRepository;
//
//        BookingService service;
//
//        static final Reservation mockReservation = Reservation.builder()
//                .id(1000L)
//                .description("initial reservation")
//                .startTime(DateTime.now().plusHours(3))
//                .endTime(DateTime.now().plusHours(4))
//                .build();
//
//        @BeforeEach
//        void setUp() {
//
//            service = new BookingService(mockReservationRepository);
//            when(mockReservationRepository.findById(mockReservation.getId()))
//                    .thenReturn(Optional.of(mockReservation));
//        }
//
//        @AfterEach
//        void tearDown() {
//            Mockito.reset(mockReservationRepository);
//        }
//
//        @Test
//        void createReservation() {
//            var toBeCreated = Reservation.builder()
//                    .description("initial reservation")
//                    .startTime(DateTime.now().plusHours(3))
//                    .endTime(DateTime.now().plusHours(4))
//                    .build();
//            service.createReservation(toBeCreated);
//            //service call createReservation的时候 repository.save()会被call一次
//            verify(mockReservationRepository).save(toBeCreated);
//            //这里就验证了mockReservationRepository的save是不是真的被call了一次
//        }
//
//        @Test
//        void deleteReservation() {
//
//            service.deleteReservation(mockReservation.getId());
//            verify(mockReservationRepository).delete(mockReservation);
//        }
//
//
//
//
//    }
