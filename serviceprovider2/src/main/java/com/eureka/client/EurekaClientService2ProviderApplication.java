package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientService2ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientService2ProviderApplication.class, args);
    }
}
