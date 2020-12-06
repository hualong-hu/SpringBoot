package org.bigjava.day07;

import org.bigjava.bean.Employee;
import org.bigjava.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Day07ApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisTemplate myRedisTemplate;


	@Test
	public void test1(){
		employeeMapper.insertEmployee(new Employee(null, "洛笙", "123@qq.com", 1, 1));

	}

	@Test
	public void test2(){
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println("employee = " + employee);
	}
	@Test
	public void test3(){
//		stringRedisTemplate.opsForValue().append("msg", "hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println("msg = " + msg);
		System.out.println("a = "+stringRedisTemplate.opsForValue().get("a"));
	}

	@Test
	public void test4(){
		Employee employee = employeeMapper.getEmpById(1);
//		redisTemplate.opsForValue().set("emp",employee );
		myRedisTemplate.opsForValue().set("emp", employee);
		System.out.println(redisTemplate.opsForValue().get("emp"));
	}
}
