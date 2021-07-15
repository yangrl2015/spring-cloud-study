package com.fegin.client.service;

import com.fegin.client.configuration.FeignConfiguration;
import com.fegin.client.service.fallback.ServiceProvider3FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * application yaml 文件中不能有name为hello的ribbon的负载配置，否则会覆盖这里的配置
 */
@FeignClient(name= "hello",url = "http://127.0.0.1:9093", configuration = FeignConfiguration.class, fallbackFactory = ServiceProvider3FallbackFactory.class)
public interface IServiceProvider3Service {
    @RequestMapping(value="/sayHello",method = RequestMethod.GET)
    String sayHello();
    @RequestMapping(value="/service3/sayHelloTimeout",method = RequestMethod.GET)
    String sayHelloTimeout();
}
