## springcloud-demo
springcloud示例项目，包含注册发现，配置中心，服务调用，熔断，网关等模块。

### springcloud-demo-config-client
配置服务客户端

### springcloud-demo-config-server
配置服务中心

### springcloud-demo-eureka
服务注册发现

### springcloud-demo-ping
服务ping

### springcloud-demo-pong
服务pong

### springcloud-demo-zuul
网关

### springcloud-zipkin-server
zipkin

### 示例运行
#####  启动服务
依次启动springcloud-demo-eureka, springcloud-demo-config-server, 然后启动其他模块ping, pong, zuul等。

#### 访问服务
- http://localhost:8761/ 查看注册中心
- http://localhost:8081/message 访问springcloud-demo-ping服务，调用springcloud-demo-pong服务返回结果。
- http://localhost:8082/message 访问springcloud-demo-pong服务
- http://localhost:8888/aaron-config-dev.properties 访问springcloud-demo-config-server服务，查看配置信息