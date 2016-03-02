package com.jason.config;

import com.jason.interceptor.AccessInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public AccessInterceptor getAccessInterceptor() {
        return new AccessInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getAccessInterceptor()).excludePathPatterns("/user/login")
//                .excludePathPatterns("/user/register")
//                .excludePathPatterns("/pics/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /root/graduateDesign/python/pics/
        // /home/jason/python/graduateDesign/tvShowSpider/pics/
        registry.addResourceHandler("/pics/**").addResourceLocations("file:/home/jason/python/graduateDesign/tvShowSpider/pics/");
        super.addResourceHandlers(registry);
    }
}
