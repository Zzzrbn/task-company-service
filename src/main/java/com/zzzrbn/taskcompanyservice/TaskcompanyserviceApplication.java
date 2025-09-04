package com.zzzrbn.taskcompanyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskcompanyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskcompanyserviceApplication.class, args);
	}
}
