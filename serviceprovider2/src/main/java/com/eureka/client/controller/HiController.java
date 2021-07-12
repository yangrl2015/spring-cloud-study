package com.eureka.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class HiController {
    private final Logger logger = LoggerFactory.getLogger(HiController.class);
    @Value("${server.port}")
    private final int port =0;

    @RequestMapping(value = "/sayHi")
    public String sayHello() {
        logger.info("sayHi info");
        logger.debug("sayHi debug");
        return "service provider 2 hi:"+port;
    }
}
