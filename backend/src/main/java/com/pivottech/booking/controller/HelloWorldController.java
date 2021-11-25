package com.pivottech.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("reservations/{id}/helloworld")

public class HelloWorldController {

    @GetMapping("/")
    public String index(@PathParam("id") String id) {
        return "Hello World!" + id;
    }
}
