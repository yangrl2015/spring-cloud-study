package com.fegin.client.controller;

import com.fegin.client.service.IServiceProvider3Service;
import com.fegin.client.service.IServiceProviderService;
import com.fegin.client.service.IServiceProviderServiceWithFallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/feign")
public class ServiceProviderController {
    @Autowired
    private IServiceProviderService iServiceProviderService;
    @Autowired
    private IServiceProviderServiceWithFallbackFactory iServiceProviderServiceWithFallbackFactory;
    @Autowired
    private IServiceProvider3Service iServiceProvider3Service;
    @RequestMapping(value="sayHello")
    public String sayHello(){

        String reponse = iServiceProviderService.sayHello();

        System.out.println("feign client invoker");
        return reponse;

    }
    @RequestMapping(value="sayHelloTimeout")
    public String sayHelloTimeout(){

        String reponse = iServiceProviderService.sayHelloTimeout();

        System.out.println("feign client invoker sayHello Timeout");
        return reponse;

    }

    @RequestMapping(value="sayHelloTimeoutwithFeignFallback")
    public String sayHelloTimeoutwithFeignFallback(){

        String reponse = iServiceProviderServiceWithFallbackFactory.sayHelloTimeout();

        System.out.println("feign client invoker sayHello Timeout");
        return reponse;

    }

    /**
     * 调用service3
     * @return
     */
    @RequestMapping(value="sayHelloTimeoutFromService3")
    public String sayHelloTimeoutFromService3(){

        String reponse = iServiceProvider3Service.sayHelloTimeout();

        System.out.println("feign client invoker sayHello Timeout from service 3");
        return reponse;

    }
}
