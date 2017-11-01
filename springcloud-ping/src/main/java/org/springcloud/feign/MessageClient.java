package org.springcloud.feign;

import org.springcloud.pojo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "springcloud-demo-pong", fallback = MesssageHystrix.class)
public interface MessageClient {

    @GetMapping(value = "/message")
    String getMessage();

    @PostMapping(value = "/getMessageBean")
    String getMessageBean(City city);
}

@Component
class MesssageHystrix implements MessageClient{

    @Override
    public String getMessage() {
        return "Hi, this message send failed";
    }

    @Override
    public String getMessageBean(City city) {
        return "Hi, this message bean send failed";
    }
}