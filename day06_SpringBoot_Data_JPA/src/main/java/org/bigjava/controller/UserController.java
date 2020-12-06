package org.bigjava.controller;

import org.bigjava.bean.User;
import org.bigjava.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: UserController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-26 15:08
 * @Version v1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/save")
    public String  saveUser(User user){
        User user1 = userDao.save(user);
        System.out.println("user1 = " + user1);
        return "success";
    }

    @GetMapping(value="/find/{id}")
    public String  find(@PathVariable("id")Integer id, Model model){
        Optional<User> user = userDao.findById(id);
        model.addAttribute("user", user);
        return "success";
    }
}
