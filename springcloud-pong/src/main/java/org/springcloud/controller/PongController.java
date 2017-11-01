package org.springcloud.controller;

import org.springcloud.pojo.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    @Value("${hiAaron}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message + " - pong";
    }

    @PostMapping("/getMessageBean")
    public String getMessageBean(@RequestBody City city) {
        return this.message + " - pong" + city.getName();
    }
}
