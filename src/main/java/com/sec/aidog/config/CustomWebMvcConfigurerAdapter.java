package com.sec.aidog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截所有的controller
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/*")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/api")
//                .excludePathPatterns("/sublogin*");
//        super.addInterceptors(registry);
//    }

//    @Bean                                   //注入方法2，去掉Component
//    LoginInterceptor loginInterceptor() {
//        return new LoginInterceptor();
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/adminlte/**").addResourceLocations("classpath:/adminlte/");
//        registry.addResourceHandler("/adminlte/pages/ui_js/chart/**").addResourceLocations("classpath:/adminlte/pages/ui_js/chart/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("/layui/**").addResourceLocations("classpath:/layui/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/templates/",".html");
        super.configureViewResolvers(registry);
    }


}
