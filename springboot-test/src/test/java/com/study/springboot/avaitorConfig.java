package com.study.springboot;

import com.googlecode.aviator.FunctionLoader;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
public class avaitorConfig {

    @Bean
    public FunctionLoader getLoader() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        return new FunctionLoader() {
            @Override
            public AviatorFunction onFunctionNotFound(String name) {
                try {
                    return (AviatorFunction) applicationContext.getBean(name);
                } catch (NoSuchBeanDefinitionException e) {
                    return null;
                }
            }
        };
    }
}
