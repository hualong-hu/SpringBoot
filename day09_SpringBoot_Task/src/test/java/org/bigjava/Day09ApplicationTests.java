package org.bigjava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;

@SpringBootTest
class Day09ApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;
	@Test
	public void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setSubject("通知：今晚开会");
		message.setText("今晚7:30开会");

		message.setTo("p1134113829@163.com");
		message.setFrom("242604249@qq.com");

		javaMailSender.send(message);

	}

}
