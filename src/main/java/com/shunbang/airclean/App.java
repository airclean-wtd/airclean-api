package com.shunbang.airclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启事务
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
