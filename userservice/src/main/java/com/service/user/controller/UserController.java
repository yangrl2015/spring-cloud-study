package com.service.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * restTemplate 方式负载均衡,使用默认的规则，即使用的是随机RandomRule
     * @return
     */
    @RequestMapping(value="/user")
    public String invoker(){
        String reponse = restTemplate.getForObject("http://SERVICEPROVIDER/sayHello", String.class);
        return reponse;

    }
}
