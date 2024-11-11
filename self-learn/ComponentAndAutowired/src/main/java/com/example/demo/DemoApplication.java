package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
		// dấu @Component.

		// Lấy Bean ra bằng cách
		Outfit outfit = context.getBean(Outfit.class);
		Outfit outfit2 = new Bikini();
		Outfit outfit3 = new Bikini();
		// In ra để xem thử nó là gì
		System.out.println("Output Instance: " + outfit);
		outfit.wear();
		System.out.println("outfit2 Instance: " + outfit2);
		System.out.println("outfit3 Instance: " + outfit3);

		Girl girl = context.getBean(Girl.class);

		System.out.println("Girl Instance: " + girl);
		System.out.println("Girl Outfit: " + girl.outfit);

		Girl girl1 = new Girl();
		System.out.println("Girl1 Instance: " + girl1);
		System.out.println("Girl1 Outfit: " + girl1.outfit);

		Girl girl2 = new Girl();
		System.out.println("Girl2 Instance: " + girl2);
		System.out.println("Girl2 Outfit: " + girl2.outfit);

//		Girl girl3 = new Girl(outfit2);
//		System.out.println("Girl3 Instance: " + girl3);
//		System.out.println("Girl3 Outfit: " + girl3.outfit);
		girl.outfit.wear();
	}

}