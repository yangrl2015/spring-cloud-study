package com.service.user.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration
@RibbonClient(name="SERVICEPROVIDER3",configuration = RibbonConfiguration.ServiceProvider3Configuraion.class)
public class RibbonConfiguration {
    class ServiceProvider3Configuraion{

        public RestTemplate restTemplate(){
          return new RestTemplate();
        }
    }
}
