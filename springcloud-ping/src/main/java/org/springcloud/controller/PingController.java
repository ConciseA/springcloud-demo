package org.springcloud.controller;

import org.springcloud.feign.MessageClient;
import org.springcloud.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Autowired
    private MessageClient client;

    @GetMapping("/message")
    public String getMessage(){
        return client.getMessage() + " - ping";
    }

    @GetMapping("/getMessageBean")
    public String getMessageBean(){
        City city = new City();
        city.setName("北京");
        return client.getMessageBean(city) + " - ping";
    }
}


