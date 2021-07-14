package com.service.user.configuration;

import com.service.user.annotation.ExcludeClass;
import org.springframework.context.annotation.Configuration;


@ExcludeClass
@Configuration
public class BeforeClass {
    public BeforeClass(){
        System.out.println("BeforeClass");
    }
}
