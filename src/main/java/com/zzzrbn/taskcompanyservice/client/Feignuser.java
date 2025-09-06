package com.zzzrbn.taskcompanyservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzzrbn.taskcompanyservice.entity.Userrecord;

@FeignClient(name = "task-user-service", contextId = "task-user-service1")
public interface Feignuser {
	
	@GetMapping("/user/{id}")
	Userrecord getUserrecord(@PathVariable Long id);
	
	@GetMapping("/user/bycompany/{companyId}")
	List<Userrecord> findByCompanyId(@PathVariable Long companyId);

	@PutMapping("/user/{id}")
	public Userrecord updateUserrecord(@PathVariable Long id
			, @RequestBody Userrecord userrecord);
	
	@DeleteMapping("/user/remove-company-from-users")
    public void removeCompanyIdFromUsers(@RequestParam Long companyId);
    
}
