package com.eureka.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping(value = "/sayHello")
 public String sayHello(){
        logger.info("sayHello info");
        logger.debug("sayHello debug");
        return "hello";
 }
}
