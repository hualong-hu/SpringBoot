package org.bigjava.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: SecurityConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-10-30 16:22
 * @Version v1.0
 */
@Configuration
public class SecurityConfigDiy extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /*
        创建 PasswordEncoder 对象，如果不创建，则会报错
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     *  自定义自己编写的登录页面
     * @data: 2020-10-31-13:41
     * @method: configure
     * @params: [http]
     * @return: void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //注销用户
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/hello").permitAll();

        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        //登录页面设置
        http.formLogin().loginPage("/login.html");
        //登录访问路径
        http.formLogin().loginProcessingUrl("/login");
        //登录成功之后，跳转路径
        http.formLogin().defaultSuccessUrl("/success.html").permitAll();
        //设置哪些路径可以直接访问，不需要认证
        http.formLogin().and().authorizeRequests().antMatchers("/hello","/login").permitAll();
        //当前登录用户，只有具有admins权限才可以访问这个路径 hasAuthority->针对某个权限  hasAnyAuthority->针对多个权限
//        http.formLogin().and().authorizeRequests().antMatchers("/index").hasAuthority("admins");
        http.formLogin().and().authorizeRequests().antMatchers("/index").hasAnyAuthority("admins,manager");

        //关闭csrf防护
        http.formLogin().and().csrf().disable();
    }
}
