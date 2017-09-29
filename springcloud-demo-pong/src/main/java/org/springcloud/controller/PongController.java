package org.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    @Value("${hiAaron}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message + "8083";
    }
}
