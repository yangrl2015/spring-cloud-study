package com.service.user.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeforeClass {
    public BeforeClass(){
        System.out.println("BeforeClass");
    }
}
