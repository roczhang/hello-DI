package com.yaguang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {


		ApplicationContext cxt =  SpringApplication.run(DemoApplication.class, args);

		String[] beans = cxt.getBeanDefinitionNames();

		for (int i = 0; i < beans.length ; i++) {

			System.out.println(beans[i]);

		}

	}
}
