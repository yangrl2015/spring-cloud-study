package com.service.user.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.service.user.rule.MyRibbonRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration

/**
 * 负载均衡自定义ribbon
 */
@RibbonClient(name="SERVICEPROVIDER",configuration = RibbonConfiguration.ServiceProvider3Configuraion.class)
public class RibbonConfiguration {
    class ServiceProvider3Configuraion{

        @Bean
        public IRule iRule(){
            System.out.println("self irule");
            return new MyRibbonRule();
        }
    }
}
