package com.service.user.configuration;

import com.service.user.annotation.ExcludeClass;
import org.springframework.context.annotation.Configuration;
//下面注释
//@AutoConfigureAfter(name="com.service.user.configuration.BeforeClass")
@ExcludeClass
@Configuration
public class AfterClassConfiguration {
    public AfterClassConfiguration(){
        System.out.println("AfterClassConfiguration");
    }
}
