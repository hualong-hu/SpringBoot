package org.bigjava.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: ConfigBean
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 23:18
 * @Version v1.0
 */
@Configuration
public class ConfigBean {
    @Value("${myTopic}")
    private String topicName;

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }

}
