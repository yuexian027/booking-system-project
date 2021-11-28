//package com.pivottech.booking.controller;
//
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.pivottech.booking.model.Availability;
//import com.pivottech.booking.model.Reservation;
//import com.pivottech.booking.model.User;
//import com.pivottech.booking.service.BookingService;
//import com.pivottech.booking.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import javax.validation.Valid;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//public class ReservationController {
//    final static int DEFAULT_PAGE_SIZE = 50;
//
//    final BookingService bookingService;
//    final UserService userService;
//
//    @Autowired
//    public ReservationController(BookingService bookingService, UserService userService) {
//        this.bookingService = bookingService;
//        this.userService = userService;
//    }
//
//    @GetMapping("")
//    public List<Reservation> list(
//            @PathVariable("username") final String username,
//            @RequestParam(name = "from") LocalDateTime from,
//            @RequestParam(name = "to") LocalDateTime to
//    ) {
//        final User user = userService.getUserByUsername(username);
//        if (user == null || user.getStudent() == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student doesn't exist");
//        }
//        return bookingService.getReservationsBetween(user.getStudent(), from, to);
//    }
//
//    @GetMapping("/{id}")
//    public Reservation getById(@PathVariable("id") long id) {
//        Reservation resv = this.bookingService.getReservationById(id);
//        if (resv == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return resv;
//    }
//
//    @PostMapping("")
//    public Reservation create (
//        @PathVariable("username") final String username;
//        @Valid @RequestBody final MarkReservationRequest request;
//        ) {
//        final User user = userService.getUserByUsername(username);
//        if (user == null || user.getStudent() == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student doesn't exist");
//        }
//
//        final Availability availability = bookingService.getAvailabilityById(request.getAvailabilityId());
//        if (availability == null || availability.getReservation() != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "not available");
//        }
//        Reservation saved = this.bookingService.createReservation((user.getStudent(), availability, request.getDescription());
//        return saved;
//    }
//
//
//
//}
