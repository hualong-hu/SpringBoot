package org.bigjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: MySecurityConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-11-01 15:37
 * @Version v1.0
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定制请求的授权规则
     * @data: 2020-11-01-15:38
     * @method: configure
     * @params: [http]
     * @return: void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登录功能，效果，如果没有登录，没有权限就会来到登录页面
        http.formLogin().loginPage("/userlogin");

        //开启自动配置的注销功能
        http.logout()
                //注销成功之后来到首页
                .logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * 定义认证规则
     * @data: 2020-11-01-15:41
     * @method: configure
     * @params: [auth]
     * @return: void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String password = new BCryptPasswordEncoder().encode("123456");

        auth.inMemoryAuthentication()
                .withUser("zhangsan").password(password).roles("VIP1","VIP2")
                .and()
                .withUser("lisi").password(password).roles("VIP1","VIP3")
                .and()
                .withUser("wangwu").password(password).roles("VIP2","VIP3");
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
