package com.mine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override //所有.html链接都要在此注册
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index"); //默认index为首页
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/register.html").setViewName("register");

        registry.addViewController("/shop_list.html").setViewName("meal/shop_list");
        registry.addViewController("/category.html").setViewName("other/category");
        registry.addViewController("/about.html").setViewName("other/about");

        registry.addViewController("/user_coupon.html").setViewName("user/user_coupon");
        registry.addViewController("/user_message.html").setViewName("user/user_message");
        registry.addViewController("/user_favorites.html").setViewName("user/user_favorites");
    }
}
