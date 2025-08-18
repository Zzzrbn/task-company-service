package com.zzzrbn.taskcompanyservice.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDTOResponse {

    private Long id;
	private String name;
	private BigDecimal budget;
    @JsonIgnoreProperties({
    	//"id", 
    	"companyId", "company"})
    private List<Userrecord> users;   
    
}
