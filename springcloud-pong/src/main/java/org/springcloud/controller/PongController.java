package org.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springcloud.pojo.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PongController {
    private static Logger logger = LoggerFactory.getLogger(PongController.class);

    @Value("${hiAaron}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        logger.info("currentTime={}", new Date());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.message + " - pong";
    }

    @PostMapping("/getMessageBean")
    public String getMessageBean(@RequestBody City city) {
        return this.message + " - pong" + city.getName();
    }
}
