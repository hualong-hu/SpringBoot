package org.bigjava.day05;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.bigjava.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Day05ApplicationTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Test
	void contextLoads() {

		//获取Redis的连接对象！
		RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
		connection.flushDb();
		connection.flushAll();
		/*
			redisTemplate	操作不同的数据类型，api和我们之前学的指令一样
			redisTemplate.opsForValue		操作字符串，等同于String
			redisTemplate.opsForList()		操作List，等同于list
			redisTemplate.opsForSet()		操作Set，等同于set
			redisTemplate.opsForHash()		....
			redisTemplate.opsForZSet()
		 */

		//很多常用的方法都可以直接通过 redisTemplate 操作，比如事务，和基本的CRUD
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("username", "洛笙");
		System.out.println(valueOperations.get("username"));
		System.out.println(redisTemplate.keys("*"));



	}

	@Test
	public void test() throws JsonProcessingException {
		User user = new User("洛笙", 20);
//		String value = new ObjectMapper().writeValueAsString(user);


		redisTemplate.opsForValue().set("user", user);
		System.out.println(redisTemplate.opsForValue().get("user"));
	}

}
