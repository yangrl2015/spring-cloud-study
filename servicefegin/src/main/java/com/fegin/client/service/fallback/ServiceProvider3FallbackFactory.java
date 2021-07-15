package com.fegin.client.service.fallback;


import com.fegin.client.service.IServiceProvider3Service;
import com.fegin.client.service.IServiceProviderServiceWithFallbackFactory;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 实现FallbackFactory工厂可以具体的调用错误信息
 */
@Component
public class ServiceProvider3FallbackFactory implements FallbackFactory<IServiceProvider3Service> {

    @Override
    public IServiceProvider3Service create(Throwable throwable) {
        return new IServiceProvider3Service() {
            @Override
            public String sayHello() {
                System.out.println("sayHello invoker error from service3:"+throwable.getMessage());
                return "sayHello invoker error from service";
            }

            @Override
            public String sayHelloTimeout() {
                System.out.println("sayHelloTimeout invoker error from service 3:"+throwable);
                return "sayHelloTimeout invoker error:"+throwable;
            }
        };
    }
}
