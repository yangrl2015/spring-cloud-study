package com.fegin.client.service;


import com.fegin.client.service.fallback.ServiceProviderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 注解fallback和fallbackFactory区别是发生熔断之后，factory会获取具体的错误信息
 * 一般fallback使用的是降级 fallbackfactory 使用的是降级
 */
@FeignClient(name="SERVICEPROVIDER3", fallbackFactory = ServiceProviderFallbackFactory.class)
public interface IServiceProviderServiceWithFallbackFactory {
    @RequestMapping(value="/sayHello",method = RequestMethod.GET)
     String sayHello();
    @RequestMapping(value="/service3/sayHelloTimeout",method = RequestMethod.GET)
     String sayHelloTimeout();
}

