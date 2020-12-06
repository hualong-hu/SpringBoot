package org.bigjava;

import org.bigjava.produce.Queue_Produce;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: TestActiveMQ
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-11 17:55
 * @Version v1.0
 */
@SpringBootTest(classes = Day12Application.class)
public class TestActiveMQ {

    @Resource
    private Queue_Produce queue_produce;

    @Test
    public void testSend(){
        queue_produce.produceMsg();
    }
}
