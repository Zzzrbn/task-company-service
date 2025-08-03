package com.zzzrbn.taskcompanyservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zzzrbn.taskcompanyservice.entity.UserDTO;

@FeignClient(name = "task-user-service")
public interface Feignuser {
	
	@GetMapping("/user")
	public List<UserDTO> showAllUsersrecords();
	
	@GetMapping("/user/{id}")
	public UserDTO getUserrecord(@PathVariable Long id);
	
	@PostMapping("/user")
	public UserDTO createUserrecord(@RequestBody UserDTO userDTO);
	
	@PutMapping("/user/{id}")
	public UserDTO updateUserrecord(@PathVariable Long id
			, @RequestBody UserDTO userDTO);
		
	@DeleteMapping("/user/{id}")
	public String deleteUserrecord(@PathVariable Long id);
	
}
