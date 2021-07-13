package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider3Application {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider3Application.class,args);
    }
}
