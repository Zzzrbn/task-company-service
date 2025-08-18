package com.zzzrbn.taskcompanyservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {
	
    //private Long id;
	@NotBlank(message = "First name is required")
    private String firstname;
	@NotBlank(message = "Last name is required")
    private String lastname;
	@Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid phone number format")
    private String phoneNumber;
    @JsonIgnoreProperties({
    	//"id", 
    	"users", "usersIds"})
    private Company company;
    private Long companyId;
}
