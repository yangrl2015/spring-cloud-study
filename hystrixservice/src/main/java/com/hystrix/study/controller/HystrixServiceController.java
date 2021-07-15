package com.hystrix.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/hystrix")
public class HystrixServiceController {
    @RequestMapping(value = "/sayHystrix",method = RequestMethod.GET)
    @HystrixCommand(
            //commandKey = "hystrixSayKey",//默认为""表示用函数名，配置全局唯一表示服务名称
            //groupKey = "hystrixGroup",//一组command，如果没有配threadPoolKey，相同的groupKey会使用同一线程池（线程池隔离情况下）
            fallbackMethod = "sayHystrixFallback",
            threadPoolKey = "sayPoll",//线程池key，可以在多个方法上定义同一个线程池
            threadPoolProperties = { //参数key 参照HystrixThreadPoolProperties，大多数是有默认值的
                  @HystrixProperty(name="coreSize",value= "1"),
                    //目前该版本只支持的属性值有"maxQueueSize" 、"coreSize" "keepAliveTimeMinutes" "queueSizeRejectionThreshold"
                    //"metrics.rollingStats.numBuckets" "metrics.rollingStats.timeInMilliseconds" 其他不支持
                    //会在调用的时候报错，但是可以在application.yaml中设置全局的
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize",value="true"),

                    //@HystrixProperty(name="maximumSize", value = "2")
            },
            commandProperties =  { //参数配置查看HystrixCommandProperties
                    //超时时间
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="1000"),
                    @HystrixProperty(name="execution.timeout.enabled", value="true")
                    //默认是线程隔离策略
                    //@HystrixProperty(name="execution.isolation.strategy",value="THREAD")
            }
    )
    public String sayHystrix() throws InterruptedException {
        System.out.println("线程："+Thread.currentThread().getName());
        Thread.sleep(2000);
        return "say Hi Hystrix";
    }
    public String sayHystrixFallback(){
        String reponse = "thread:"+Thread.currentThread().getName()+","+"sayHystrixFallback";
        System.out.println(reponse);
        return reponse;
    }
}
