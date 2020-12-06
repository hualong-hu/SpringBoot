package org.bigjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: FirstSpringBootController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-19 17:54
 * @Version v1.0
 */
@Controller
public class FirstSpringBootController {

    @ResponseBody
    @RequestMapping(value="/hello")
    public String  hello(){
        return "Hello SpringBoot";
    }
}
