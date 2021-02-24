package com.study;

import com.study.bean.Pet;
import com.study.bean.User;
import com.study.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @SpringBootApplication 来标注一个主程序类，表示这是一个Spring Boot应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        //1.返回ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(HelloWorldMainApplication.class, args);

        //2.查看容器中的组件
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
        User user01 = context.getBean("user", User.class);
        User user02 = context.getBean("user", User.class);
        System.out.println(user01 == user02);

        //代理对象：com.study.config.MyConfig$$EnhancerBySpringCGLIB$$4f5d2f1@76f10035
        MyConfig myConfig = context.getBean(MyConfig.class);
        System.out.println(myConfig);

        //4.如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件容器中是否有
        //保持组件单实例
        User user03 = myConfig.user();
        User user04 = myConfig.user();

        System.out.println(user03 == user04);

        User user05 = context.getBean("user", User.class);
        Pet pet = context.getBean("tomcat", Pet.class);

        System.out.println(user05.getPet() == pet);

    }
}
