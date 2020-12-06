package org.bigjava.config;

import org.bigjava.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: MyConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-20 16:37
 * @Version v1.0
 */
@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
