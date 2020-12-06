package org.bigjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 通过配置类配置用户名和密码，需要手动创建 PasswordEncoder 对象
     * @data: 2020-10-30-16:32
     * @method: configure
     * @params: [auth]
     * @return: void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //将密码进行加密处理
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("123");
        auth.inMemoryAuthentication().withUser("123").password(password).roles("admin");
    }

    /*
        创建 PasswordEncoder 对象，如果不创建，则会报错
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
