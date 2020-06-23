package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.swing.text.View;
import java.util.Locale;

@SpringBootApplication
public class SpringBoot04WebRestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04WebRestfulcrudApplication.class, args);
	}

	@Bean
	public ViewResolver myViewResolver() {
		return new MyViewResolver();
	}

	public static class MyViewResolver implements ViewResolver {

		@Override
		public org.springframework.web.servlet.View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}
}
