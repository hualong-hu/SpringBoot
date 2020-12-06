package org.bigjava.service;

import org.bigjava.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: BookService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-29 11:07
 * @Version v1.0
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息 = " + book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive2(Message message){
        System.out.println("message = " + message.getBody());
        System.out.println("message = " + message.getMessageProperties());
    }
}
