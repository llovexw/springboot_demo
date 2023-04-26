package com.kuang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-04-04-22:52
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控 web.xml
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //后台需要有人登录
        HashMap<String, String> initParameters = new HashMap<>();

        //增加配置
        //必须是固定的loginUsername和loginPassword,自动跳转到login.html页面
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁可以访问
        initParameters.put("allow","");

        //禁止谁能访问
//        initParameters.put("kuangshen","192.168.11.123");

        bean.setInitParameters(initParameters);//设置初始化参数
        return bean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStartFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //可以过滤那些请求？
        HashMap<String, String> initParameters = new HashMap<>();

        //这些东西不进行统计
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);

        return bean;
    }
}
