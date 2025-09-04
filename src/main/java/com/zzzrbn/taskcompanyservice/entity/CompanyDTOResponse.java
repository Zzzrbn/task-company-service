package com.zzzrbn.taskcompanyservice.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class CompanyDTOResponse {
	
    private Long id;
	private String name;
	private BigDecimal budget;
    @JsonIgnoreProperties({"companyId", "company"})
    private List<Userrecord> users;
	
    @Override
	public int hashCode() {
		return Objects.hash(budget, name, users);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyDTOResponse other = (CompanyDTOResponse) obj;
		return Objects.equals(budget, other.budget) && Objects.equals(name, other.name)
				&& Objects.equals(users, other.users);
	}   
    
    
}
