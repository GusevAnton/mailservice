package com.mycompany.kanban.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication(scanBasePackages = {
		"com.mycompany.kanban.mailservice.endpoint",
		"com.mycompany.kanban.mailservice.service",
		"com.mycompany.common.function"})
@EnableEurekaClient
@EnableAsync
public class MailService {

	public static void main(String[] args) {
		SpringApplication.run(MailService.class, args);
	}

	@Bean
	public Executor executor() {
		return Executors.newCachedThreadPool();
	}

}
