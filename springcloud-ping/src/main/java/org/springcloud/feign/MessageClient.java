package org.springcloud.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springcloud.pojo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "springcloud-demo-pong", fallbackFactory = MesssageHystrixfallbackFactory.class)
public interface MessageClient {

    @GetMapping(value = "/message")
    String getMessage(); // pong接口睡了10s

    @PostMapping(value = "/getMessageBean")
    String getMessageBean(City city);
}

@Component
class MesssageHystrixfallbackFactory implements FallbackFactory<MessageClient>{
    private static final Logger logger = LoggerFactory.getLogger(MesssageHystrixfallbackFactory.class);

    @Override
    public MessageClient create(Throwable cause) {
        logger.error("触发熔断={}", cause.getMessage());
        return new MessageClient() {
            @Override
            public String getMessage() {
                return "Hi, this message send failed";
            }

            @Override
            public String getMessageBean(City city) {
                return "Hi, this message bean send failed";
            }
        };
    }
}