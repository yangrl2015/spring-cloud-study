package com.service.user.configuration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

@AutoConfigureAfter(name="com.service.user.configuration.BeforeClass")
@Configuration
public class AfterClassConfiguration {
    public AfterClassConfiguration(){
        System.out.println("AfterClassConfiguration");
    }
}
