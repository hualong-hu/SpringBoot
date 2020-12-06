package org.bigjava.Config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: MyRabbitConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-29 10:56
 * @Version v1.0
 */
@Configuration
public class MyRabbitConfig {
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
