package org.bigjava.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: AsyncService
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-29 14:13
 * @Version v1.0
 */
@Service
public class AsyncService {

    //告诉Spring这是一个异步方法
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中....");
    }

}
