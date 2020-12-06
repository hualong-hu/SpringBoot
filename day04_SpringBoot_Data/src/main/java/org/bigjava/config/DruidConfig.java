package org.bigjava.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ProjectName: JavaEESenior
 * @ClassName: DruidConfig
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-08-24 17:36
 * @Version v1.0
 */
//@Configuration
public class DruidConfig {

//    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
//    @Bean
    public ServletRegistrationBean<StatViewServlet> registrationBean(){
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        HashMap<String, String> map = new HashMap<>();

        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");//默认是允许所有访问
        registrationBean.setInitParameters(map);
        return registrationBean;
    }

//    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
