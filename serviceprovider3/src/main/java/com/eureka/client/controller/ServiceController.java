package com.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/service3")
public class ServiceController {
    @RequestMapping(value = "/hello")
    public String serviceHello(){
        System.out.println("service 3 provider hello");
        return "service provider3 sayHello";
    }
}
