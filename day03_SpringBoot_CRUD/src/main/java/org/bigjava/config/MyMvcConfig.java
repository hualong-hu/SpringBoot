package org.bigjava.config;

import org.bigjava.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: MyMvcConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-21 16:09
 * @Version v1.0
 */
//使用WebMvcConfigurer可以扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        //浏览器发送/bigjava 请求来到 success 页面
//        registry.addViewController("/bigjava").setViewName("success");
//
//
//        registry.addViewController("/index.html").setViewName("login");
//        registry.addViewController("/").setViewName("login");
//    }

    //静态文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态文件
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //webjar文件
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //浏览器发送/或 /index.html请求来到 login.html 页面
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
                registry.addViewController("/register").setViewName("register");
                registry.addViewController("/toAddPage").setViewName("/product/add");
            }
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/register","/index.html","/","/user/login","/static/**","/webjars/**","/register/checkUsername","/user/register","/defaultKaptcha","/register/checkCode");
            }
        };

        return configurer;
    }
}
