package org.bigjava.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: TestController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-30 14:54
 * @Version v1.0
 */
@RestController
public class TestController {

    @GetMapping(value="/hello")
    public String  hello(){

        return "success";
    }

    @GetMapping("/index")
    public String login(){

        return "hello index";
    }

    @GetMapping(value="/update")
    //用户具有某个角色，才可以访问该方法
    //@Secured({"ROLE_sale","ROLE_manager"})
    //方法执行之前验证是否具有权限
    //@PreAuthorize("hasAnyAuthority('manager')")
    //方法执行之后验证是否具有权限
    //@PostAuthorize("hasAnyRole('ROLE_sales')")
    public String  update(){
        System.out.println("update..............");
        return "hello update";
    }


}
