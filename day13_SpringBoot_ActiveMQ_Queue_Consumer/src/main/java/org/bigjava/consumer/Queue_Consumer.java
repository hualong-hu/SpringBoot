package org.bigjava.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: Queue_Consumer
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 23:01
 * @Version v1.0
 */
@Component
public class Queue_Consumer {


    //配置消费者监听器
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException {
        System.out.println("消费者接收到的消息 = " + textMessage.getText());
    }

}
