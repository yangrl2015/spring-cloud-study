package com.fegin.client.configuration;

import feign.Retryer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    /**
     *使用feign自身的尝试次数，
     * 如果有ribbon则应该优先使用ribbon，不需要使用
     * feign自身的。
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        /**
         * period: 100,发起当前请求的时间间隔，单位ms
         * maxPeriod：1000发起当前请求的最大时间间隔，单位ms
         * maxAttempts：5 最大尝试5次，包括第一次
         *
         */
        System.out.println("fegin retry invoker");
        new Retryer.Default(100, 1000, 5);
        return new Retryer.Default(100, 1000, 5);
    }
}
