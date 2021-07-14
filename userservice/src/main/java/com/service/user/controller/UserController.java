package com.service.user.controller;


import com.netflix.appinfo.InstanceInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    //注意这里是spring cloud的discoveryclient 不是netflix的
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * restTemplate 方式负载均衡,使用默认的规则，即使用的是随机RandomRule
     * 默认是RoundleRobinRule轮询
     * RandomRule：随机
     * AvaliablilityFilteringRule 会先过滤掉由于多次访问故障而处于短路跳闸状态的服务
     * WeightedReponseTimeRule：根据平均响应时间计算所有服务的权重，响应时间越快的服务权重越大，越被选中的概率越高
     * 刚启动时候，如果统计信息不，则使用RoundRobinRule策略，等统计信息足够会切换到这个
     * RetryRule：先按照RounRobbionRule策略获取服务，如果获取服务失败则在指定的时间内进行充实，获取可用的服务
     * BestAvailableRule： 会先过滤掉富哦次访问故障而处于断路器挑战状态的服务，然后选择一个并发量最小的服务
     * ZoneAvoidanceRule：默认规则，复合判断server所在区域的性能和server的可用性选择服务器
     * @return
     */
    @RequestMapping(value="/user")

    public String invoker(){
        String reponse = restTemplate.getForObject("http://SERVICEPROVIDER/sayHello", String.class);
        return reponse;

    }

    /**
     * 过时请求数据
     * @return
     */
    @RequestMapping(value="/userTimeout")
    public String sayHelloTimeout(){
        System.out.println("service user time out ");
        String reponse = restTemplate.getForObject("http://SERVICEPROVIDER/sayHelloTimeout", String.class);

        return reponse;

    }
    /**
     * 通过discovery获取服务实例信息
     * @return
     */
    @RequestMapping(value="/discovery")
    public String discoveryService(){
        System.out.println("discoveryService user time out ");
        List<ServiceInstance> serviceInstances =  discoveryClient.getInstances("SERVICEPROVIDER");
        serviceInstances.stream().forEach(instanceInfo -> {
            System.out.println("instanceId:"+instanceInfo.getInstanceId()+ ",port:"+instanceInfo.getPort()+ ",url:"+instanceInfo.getUri());
        });

        return "discovery";

    }

    /**
     * 通过discovery获取服务实例信息
     * @return
     */
    @RequestMapping(value="/retry")
    public String retry(){
        System.out.println("service user time retry ");
        String reponse = restTemplate.getForObject("http://SERVICEPROVIDER/sayHello", String.class);

        return "reponse:"+reponse+",retry";

    }

    /**
     * service3服务
     * @return
     */
    @RequestMapping(value="/service3")
    public String service3sayHello(){
        System.out.println("service3 user time retry ");
        String reponse = restTemplate.getForObject("http://SERVICEPROVIDER/sayHello", String.class);

        return "service 3 reponse:"+reponse+",retry";

    }

}
