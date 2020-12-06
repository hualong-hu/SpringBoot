package org.bigjava.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.jms.Queue;


/**
 * @ProjectName: JavaEESenior
 * @ClassName: ConfigBean
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 17:40
 * @Version v1.0
 */
@Configuration
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }
}
