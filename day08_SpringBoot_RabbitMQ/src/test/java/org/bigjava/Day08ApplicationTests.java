package org.bigjava;

import org.bigjava.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class Day08ApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void test3(){
//		amqpAdmin.declareExchange(new DirectExchange("ampqAdmin.exchange"));
//		System.out.println("创建完成");

//		amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));

		//创建绑定规则
		amqpAdmin.declareBinding(new Binding("amqpAdmin.queue", Binding.DestinationType.QUEUE,"ampqAdmin.exchange","amqp.haha",null));
		
	}


	/**
	 * 单播
	 * @data: 2020-10-29-11:02
	 * @method: contextLoads
	 * @params: []
	 * @return: void
	 */
	@Test
	public void contextLoads() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("msg", "这是一个消息");
		map.put("data", Arrays.asList("hello world",123,true));
		//对象被默认序列化以后发送出去，object默认当初消息体只需要传入要发送的对象。自动序列化发给rabbitmq
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("逆天邪神", "火星引力"));
	}

	/**
	 * 接收数据，如何将数据自动转为json发送出去
	 * @data: 2020-10-29-10:51
	 * @method: test
	 * @params: []
	 * @return: void
	 */
	@Test
	public void test1(){
		Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
		System.out.println("o = " + o);
		System.out.println(o.getClass());
	}

	@Test
	public void test2(){
		rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("红楼梦", "曹雪芹"));
	}
}
