package com.fegin.client.service;

import com.fegin.client.service.fallback.ServiceProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * fallback 一般用于降级，当用于降级时将feign.hystrix.enabled 设置为true
 */
@FeignClient(name="SERVICEPROVIDER", fallback= ServiceProviderFallback.class)
public interface IServiceProviderService {
    @RequestMapping(value="/sayHello",method = RequestMethod.GET)
     String sayHello();
    @RequestMapping(value="/sayHelloTimeout",method = RequestMethod.GET)
     String sayHelloTimeout();
}

