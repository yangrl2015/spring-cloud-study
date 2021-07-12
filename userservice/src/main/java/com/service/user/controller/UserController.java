package com.service.user.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value="/user")
    public String invoker(){
        restTemplate.getForObject("http://SERVICEPROVIDER/sayHello", String.class);
        return "user invoker";

    }
}
