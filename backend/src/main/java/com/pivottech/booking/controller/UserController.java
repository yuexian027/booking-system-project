package com.pivottech.booking.controller;

import com.pivottech.booking.model.Instructor;
import com.pivottech.booking.model.Student;
import com.pivottech.booking.model.User;
import com.pivottech.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    public User createUser(@RequestBody User user) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username already existed.");
        }
        return userService.createUser(user);
    }

    @PostMapping("students/{username}")
    public Student createOrUpdateStudent (
            @PathVariable("username") String username,
            @RequestBody Student student
    ) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username doesn't exist.");
        }
        Student updated = userService.updateStudentProfile(username, student);
        return updated;
    }
    @PostMapping("instructors/{username}")
    public Instructor createOrUpdateInstructor(
            @PathVariable("username") String username,
            @RequestBody Instructor instructor
    ) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "username doesn't exist.");
        }
        Instructor updated = userService.updateStudentProfile(username, instructor);
        return updated;
    }
}
