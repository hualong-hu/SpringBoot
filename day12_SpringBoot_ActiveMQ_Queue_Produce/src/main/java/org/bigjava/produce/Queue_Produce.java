package org.bigjava.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Queue_Produce
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 17:41
 * @Version v1.0
 */
@Component
public class Queue_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(queue, "------>"+ UUID.randomUUID().toString().substring(0, 6));
        System.out.println("消息发送成功！！！！");
    }

    //间隔3秒钟定投
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(queue, "Scheduled------>"+ UUID.randomUUID().toString().substring(0, 6));
        System.out.println("Scheduled消息发送成功！！！！");
    }

}
