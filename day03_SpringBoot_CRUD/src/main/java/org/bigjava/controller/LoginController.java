package org.bigjava.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.bigjava.bean.User;
import org.bigjava.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: LoginController
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-22 10:26
 * @Version v1.0
 */
@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;
    /**
     * 用户登录
     * @data: 2020-08-27-10:48
     * @method: login
     * @params: [username, password, map, session]
     * @return: java.lang.String
     */
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Map<String,Object> map, HttpSession session){

        User username1 = userService.selectByUsernameAndPassword(username, password);

        if (username1 != null){
            session.setAttribute("loginUser", username);
            return  "redirect:/main.html";
        } else {
            map.put("msg", "用户名不存在或密码输入错误,请重新输入!");
            return "login";
        }
    }

    /**
     * 用户注销
     * @data: 2020-08-27-10:48
     * @method: logout
     * @params: []
     * @return: java.lang.String
     */
    @GetMapping(value="/user/logout")
    public String  logout(HttpSession session){
        //销毁session
        session.invalidate();
        return "login";
    }

    /**
     * 校验用户名是否可用
     * @data: 2020-08-29-10:13
     * @method: checkUsername
     * @params: [username]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @GetMapping(value="/register/checkUsername")
    @ResponseBody
    public Map<String,Object> checkUsername(@RequestParam("username")String username){
        User username1 = userService.selectByUsernameAndPassword(username, null);
        HashMap<String, Object> map = new HashMap<>();
        if (username1 != null){
            map.put("msg", "用户名已存在！请重新输入");
        }else {
            map.put("successInfo", "用户名可用!");
        }

        return map;
    }
    /**
     * 校验验证码是否正确
     * @data: 2020-08-29-10:19
     * @method: checkCode
     * @params: []
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @RequestMapping(value="/register/checkCode")
    public Map<String , Object>  checkCode(@RequestParam("code")String code,HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        String rightCode = (String)session.getAttribute("rightCode");
        System.out.println(code.equals(rightCode));
        if (!code.equals(rightCode)){
            map.put("codeMsg", "验证码输入错误，请重新输入");
        }
        return map;
    }

    /**
     * 保存用户注册信息
     * @data: 2020-08-28-22:53
     * @method: register
     * @params: [user]
     * @return: java.lang.String
     */
    @PostMapping(value="/user/register")
    @ResponseBody
    public Map<String,Object> register(User user){
        HashMap<String, Object> map = new HashMap<>();
        System.out.println("成功");
        userService.insert(user);
        map.put("msg", "用户注册成功！点击确定回到登录页面");
        return map;
    }

    @Autowired
    DefaultKaptcha defaultKaptcha;
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("rightCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);

        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

}
