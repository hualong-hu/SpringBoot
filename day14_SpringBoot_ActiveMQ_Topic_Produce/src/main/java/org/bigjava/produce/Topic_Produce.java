package org.bigjava.produce;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;
import java.util.UUID;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Topic_Produce
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 23:21
 * @Version v1.0
 */
@Component
public class Topic_Produce {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Topic topic;

    @Scheduled(fixedDelay = 3000)
    public void produceTopic(){
        jmsMessagingTemplate.convertAndSend(topic, "主题消息："+ UUID.randomUUID().toString().substring(0, 6));
        System.out.println("主题消息发送成功！！！");
    }


}
