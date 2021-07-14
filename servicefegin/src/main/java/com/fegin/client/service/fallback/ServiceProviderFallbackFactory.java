package com.fegin.client.service.fallback;


import com.fegin.client.service.IServiceProviderServiceWithFallbackFactory;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 实现FallbackFactory工厂可以具体的调用错误信息
 */
@Component
public class ServiceProviderFallbackFactory implements FallbackFactory<IServiceProviderServiceWithFallbackFactory> {

    @Override
    public IServiceProviderServiceWithFallbackFactory create(Throwable throwable) {
        return new IServiceProviderServiceWithFallbackFactory() {
            @Override
            public String sayHello() {
                System.out.println("sayHello invoker error:"+throwable.getMessage());
                return "sayHello invoker error:";
            }

            @Override
            public String sayHelloTimeout() {
                System.out.println("sayHelloTimeout invoker error:"+throwable);
                return "sayHelloTimeout invoker error:"+throwable;
            }
        };
    }
}
