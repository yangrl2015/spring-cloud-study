package com.fegin.client.service.fallback;

import com.fegin.client.service.IServiceProviderService;
import org.springframework.stereotype.Component;

@Component
public class ServiceProviderFallback implements IServiceProviderService {
    @Override
    public String sayHello() {
        System.out.println("sayHello 调用失败");
        return null;
    }

    @Override
    public String sayHelloTimeout() {
        System.out.println("sayHelloTimeout调用失败");
        return "sayHelloTimeout调用失败";
    }
}
