package org.springcloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "springcloud-demo-pong")
public interface MessageClient {

    @GetMapping(value = "/message")
    String getMessage();
}
