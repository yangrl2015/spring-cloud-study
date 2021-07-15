package com.fegin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.fegin.client.service")
public class FeignServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApplication.class, args);
    }
}
