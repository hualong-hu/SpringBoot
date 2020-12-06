package org.bigjava;
import java.util.List;


import org.bigjava.entity.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 SpringBoot单元测试
 可以在测试期间很方便的像编码一一进行自动注入
 */
@SpringBootTest
class ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext context;



    @Test
    public void testLog(){
        //日志记录器
        Logger logger = LoggerFactory.getLogger(getClass());
        /*
            日志的级别：
                由低到高 ---> trace<debug<info<warn<error
            可以调整输出的日志级别：日志就只会在这个级别以后的高级别生效
         */
        logger.trace("这是trace日志.....");
        logger.debug("这是debug日志.....");
        /*
            SpringBoot默认给我们使用的是info级别的，没有指定级别的就用
                SpringBoot默认规定的级别：root级别
         */
        logger.info("这是info日志....");
        logger.warn("这是warn日志....");
        logger.error("这是error日志....");
    }

    @Test
    public void test(){
        boolean bean = context.containsBean("helloService");
        System.out.println("bean = " + bean);
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }














}
