package com.eureka.client.controller;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class HelloController {
    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Value("${server.port}")
    private final int port=0;

    @RequestMapping(value = "/sayHello")
    public String sayHello() {
        logger.info("sayHello info");
        logger.debug("sayHello debug");
        return "service provider 1 hello:"+port;
    }

    /**
     * 制造超时测试readTimeout，
     * @return
     */
    @RequestMapping(value = "/sayHelloTimeout")
    public String sayHelloTimeout() throws InterruptedException {
        logger.info("sayHelloTimeout info");
        logger.debug("sayHelloTimeout debug");
        Thread.sleep(5000);
        return "service timeout provider 1 hello:"+port;
    }
}
