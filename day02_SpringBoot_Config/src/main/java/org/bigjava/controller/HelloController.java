package org.bigjava.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-20 15:15
 * @Version v1.0
 */
//这个类的所有方法返回的数据直接写给浏览器（如果是对象转为json数据）
@RestController
public class HelloController {
    @RequestMapping(value="/hello")
    @ResponseBody
    public String  hello(){

        return "hello quick start SpringBoot!!!";
    }

}
