package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.test.controller.UserController;
import com.test.serviceImpl.UserServiceImpl;

@SpringBootApplication
@ComponentScan(basePackageClasses = {UserController.class, UserServiceImpl.class})
@EnableJpaRepositories("com.test.dao")
@EntityScan("com.test.entity")
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
