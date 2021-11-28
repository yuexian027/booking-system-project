//package com.pivottech.booking.controller;
//
//
//import com.pivottech.booking.model.Availability;
//import com.pivottech.booking.model.User;
//import com.pivottech.booking.service.BookingService;
//import com.pivottech.booking.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import javax.validation.Valid;
//import java.time.Duration;
//import java.time.LocalDateTime;
//
//@RestController
//@RequestMapping("{username}/availabilities")
//public class AvailabilityController {
////
//    @Autowired
//    BookingService bookingService;
//
//    @Autowired
//    UserService userService;
//
//    @GetMapping("")
//    public Iterable<Availability> list (
//            @PathVariable("username")String username,
//            @RequestParam(name = "from")LocalDateTime from,
//            @RequestParam(name = "tp") LocalDateTime to
//            ) {
//        User user = userService.getUserByUsername(username);
//        if (user == null || user.getInstructor() == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"instructor does not exist");
//        }
//        return bookingService.findAvailabilitiesBetween(user.getInstructor(), from, to);
//    }
//
//    @PostMapping("")
//    public Iterable<Availability> create(
//            @PathVariable("username") String username,
//            @Valid @RequestBody CreateAvailabilityRequest request
//    ){
//       User user = userService.getUserByUsername(username);
//       if (user == null || user.getInstructor() == null) {
//           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"instructor does not exist");
//       }
//       LocalDateTime from = request.getFromUtc();
//       LocalDateTime to = request.getToUtc();
//       if (from.isAfter(to)) {
//           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"from must be earlier than to");
//       }
//       Duration duration = Duration.ofMinutes(request.getDurationMinutes());
//
//       return bookingService.createAvailability(user.getInstructor(), from, to,duration);
//    }
//
//}
