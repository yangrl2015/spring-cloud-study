package com.service.user;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@SpringBootApplication
/**@EnableDiscoveryClient和@EnableEurekaClient 区别：
 * 1 discovery基于spring-cloud-common包，eureka基于netflix-eureka-client
 * 2 eureka只支持eureka-client的服务发现，而discovery则支持eureka zookeeper consul等注册中心
 * 3 官方推荐使用discovery方式
 *
 */
@EnableDiscoveryClient

public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        //SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setConnectTimeout(5000);
        httpComponentsClientHttpRequestFactory.setReadTimeout(5000);

        return new RestTemplate(httpComponentsClientHttpRequestFactory);
    }

    /**
     *      * RandomRule：随机
     * AvaliablilityFilteringRule 会先过滤掉由于多次访问故障而处于短路跳闸状态的服务
     * WeightedReponseTimeRule：根据平均响应时间计算所有服务的权重，响应时间越快的服务权重越大，越被选中的概率越高
     * 刚启动时候，如果统计信息不，则使用RoundRobinRule策略，等统计信息足够会切换到这个
     * RetryRule：先按照RounRobbionRule策略获取服务，如果获取服务失败则在指定的时间内进行充实，获取可用的服务
     * BestAvailableRule： 会先过滤掉富哦次访问故障而处于断路器挑战状态的服务，然后选择一个并发量最小的服务
     * ZoneAvoidanceRule：默认规则，复合判断server所在区域的性能和server的可用性选择服务器
     * 可以通过编程式这种方式修改，也可以通过application.yaml文件修改
     * @return
     */
//    @Bean
//    public IRule getRandomRule(){
//        return new RandomRule();
//    }


}
