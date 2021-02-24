package com.study.config;

import com.study.bean.Pet;
import com.study.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1.配置类中使用@Bean标注在方法上给容器中添加组件，默认是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods: 代理bean的方法
 *      Full(proxyBeanMethods = true)
 *      Lite(proxyBeanMethods = false)
 *      解决组件依赖场景
 */
@Configuration(proxyBeanMethods = true) //告诉SpringBoot这是一个配置类，也就是原来的配置文件
public class MyConfig {

    /**
     * @Bean给容器中添加组件就是原来配置文件中的<bean></bean>标签。
     *     方法名就是bean标签的id属性，返回类型就是组件的类型（class属性），返回值就是容器中组件的实例
     *
     * proxyBeanMethods = true:
     * 外部无论对配置类中的这个组件祖册方法调用多少次，获取的都是之前注册进容器的单实例对象。
     *
     * @return
     */
    @Bean
    public User user() {
        User user = new User("hql", 24);
        //user组件依赖了pet组件
        user.setPet(pet());
        return user;
    }

    @Bean("tomcat")
    public Pet pet() {
        return new Pet("Tom");
    }
}
