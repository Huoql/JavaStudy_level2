package com.study.springboot;

import com.study.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * SpringBoot单元测试
 *
 * 可以再测试区间很方便的类似编码一样进行自动注入等容器的功能
 *
 */
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void testHelloService() {
		Boolean result = ioc.containsBean("helloService");
		System.out.println(result);
	}

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
