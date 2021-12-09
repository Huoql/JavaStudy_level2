package com.study.config;

import com.study.interceptor.AnnotationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    AnnotationInterceptor annotationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(annotationInterceptor).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
