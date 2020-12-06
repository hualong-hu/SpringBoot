package org.bigjava.controller;

import org.bigjava.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: AsyncController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-29 14:45
 * @Version v1.0
 */

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping(value="/hello")
    public String  hello(){
        asyncService.hello();
        return "success";
    }
}
