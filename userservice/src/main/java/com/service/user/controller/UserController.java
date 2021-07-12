package com.service.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

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
}
