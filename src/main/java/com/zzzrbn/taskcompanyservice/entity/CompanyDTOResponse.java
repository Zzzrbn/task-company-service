package com.zzzrbn.taskcompanyservice.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class CompanyDTOResponse {
    private Long id;
	private String name;
	private BigDecimal budget;
    @JsonIgnoreProperties({"companyId", "company"})
    private List<Userrecord> users;   
    
}
