package com.eureka.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    //@Value("${spring.cloud.client.hostname}")
    @Value("${myProperties.clientHostname}")
    private  String clientHostname;
    @Autowired
    private Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
        //System.out.println(clientHostname);
    }
    @Bean
    public String testBean(){
        System.out.println(environment.getProperty("spring.cloud.client.hostname"));
        System.out.println("ss:"+clientHostname);
        return "hello";
    }

}
