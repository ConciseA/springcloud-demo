package org.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "springcloud-demo-pong", fallback = MesssageHystrix.class)
public interface MessageClient {

    @GetMapping(value = "/message")
    String getMessage();
}


@Component
class MesssageHystrix implements MessageClient{

    @Override
    public String getMessage() {
        return "Hi, this message send failed";
    }
}