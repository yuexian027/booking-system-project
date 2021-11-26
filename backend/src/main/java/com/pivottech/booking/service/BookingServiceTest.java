//package com.pivottech.booking.service;
//
//import com.pivottech.booking.model.Reservation;
//import org.joda.time.DateTime;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import com.pivottech.booking.repository.ReservationRepository;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.persistence.MapKeyColumn;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class BookingServiceTest {
//    @Mock
//    ReservationRepository mockReservationRepository;
//
//    BookingService service;
//
//
//
//    @BeforeEach
//    void setUp() {
//        service = new BookingService(mockReservationRepository);
//        service.createReservation(
//                Reservation.builder()
//                        .description("initial reservation")
//                        .startTime(DateTime.now())
//                        .endTime(DateTime.now().plusHours(1))
//                        .build()
//        );
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    //test 这里会有小箭头 每次会在这里run
//    //每次run这里的时候 @Before Each下面的Setup就会被执行 （before All的话就是只做一次）
//    //每次test结束的时候 @AfterEach就会被执行
//    @Test
//    void createReservation() {
//        int totalReservations = service.getReservations().size();
//        service.createReservation(
//                Reservation.builder()
//                        .description("initial reservation")
//                        .startTime(DateTime.now().plusHours(3))
//                        .endTime(DateTime.now().plusHours(4))
//                        .build()
//        );
//        //正确的值 vs 得到的值
//        assertEquals(totalReservations + 1, service.getReservations().size());
//    }
//    //这个test前面也会有小箭头 这里测试的是service的delete的这个method
//    @Test
//    void deleteReservation() {
//        service.deleteReservation(0L);
//        assertEquals(0, service.getReservations().size());
//    }
//
//    @Test
//    void getReservations() {
//    }
//}