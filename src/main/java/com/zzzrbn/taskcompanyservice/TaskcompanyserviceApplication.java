package com.zzzrbn.taskcompanyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient теперь по имени из пропертис автоматом регистрируется на сервере при добавлении в пом зависимости клиента
public class TaskcompanyserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskcompanyserviceApplication.class, args);
		
		
	}

}
