package com.zzzrbn.taskcompanyservice.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CompanyDTORequest {

	@NotBlank(message = "Company name is required")
	private String name;
	
	@Min(value = 0, message = "Budget must be >= 0")
	private BigDecimal budget;
	
    @JsonIgnoreProperties({"companyId", "company"})
    private List<Long> userrecordIds = new ArrayList<>();
}
