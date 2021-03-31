package com.study.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;

@SpringBootTest
class SpringbootTestApplicationTests {

	/**
	 * 用java语言实现两个函数encode()和decode()，分别实现对字符串的变换和复原．变换函数encode()顺序考察已知字符串的字符，按以下规则逐组生成新字符串:
	 *
	 * (1)若已知字符串的当前字符不是大于0的数字字符，则复制该字符于新字符串中；
	 *
	 * (2)若已知字符串的当前字符是一个数字字符，且它之后没有后继字符，则简单地将它复制到新字符串中；
	 *
	 * (3)若已知字符串的当前字符是一个大于0的数字字符，并且还有后继字符，设该数字字符的面值为n，则将它的后继字符（包括后继字符是一个数字字符）重复复制n+1次到新字符串中；
	 *
	 * (4)若已知字符串中包含有下划线'_',则变换为 ”\UL” 。
	 *
	 * (5)以上述一次变换为一组，在不同组之间另插入一个下划线'_'用于分隔；
	 */
	@Test
	void contextLoads() {
		System.out.println(encode("24ab_2t2"));
		System.out.println(decode(encode("24ab_2t2")));
	}

	public String encode(String original) {
		StringBuffer target = new StringBuffer();
		for (int i = 0; i < original.length() - 1; i++) {
			char c1 = original.charAt(i);
			char c2 = original.charAt(i+1);

			if(c1 == '_') {//步骤4
				target.append("\\UL");
			}else if(c1 > '0' && c1 <= '9') {//是一个数字字符
				int number = Integer.valueOf(String.valueOf(c1)) + 1;
				for(int j = 0; j < number; j++) { //循环n+1次
					target.append(c2);
				}
			}else { //不是一个数字字符
				target.append(c1);
			}
			target.append("_");
		}
		target.append(original.charAt(original.length() - 1));
		return target.toString();
	}

	public String decode(String original) {
		String[] originalArray = original.split("_");
		StringBuffer target = new StringBuffer();

		for (int i = 0; i < originalArray.length; i++) {
			if(originalArray[i].equals("\\UL")) {
				target.append("_");
			}else if (originalArray[i].length() == 1) {
				target.append(originalArray[i]);
			}else {
				target.append(originalArray[i].length() - 1);
			}
		}
		return target.toString();
	}

	@Test
	void a() {
		Calendar calendar = Calendar.getInstance();

		int max = calendar.getActualMaximum(
				Calendar.DAY_OF_MONTH);
		System.out.println(max);
	}

	int recurrence(int n) {
		if(n == 1 || n == 2) {
			return n;
		}else {
			return n + recurrence(n-1);
		}
	}

	public static void main(String[] args) {
		SpringbootTestApplicationTests a = new SpringbootTestApplicationTests();
		System.out.println(a.recurrence(10));
		System.out.println(String.format("%06d", Integer.parseInt("G061".substring(1)) + 1));
	}
}
