package com.zzzrbn.taskcompanyservice.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTO;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;

@Component
public class CompanyMapper {

    public CompanyDTO toDTO(Company company, List<Userrecord> userrecords) {
        if (company == null) {
            return null;
        }
        
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setBudget(company.getBudget());
        dto.setUsers(userrecords);
                
        return dto;
    }

    public Company toEntity(CompanyDTO companyDTO) {
        if (companyDTO == null) {
            return null;
        }
        
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setBudget(companyDTO.getBudget());
        
        if (companyDTO.getUsers() != null) {
            company.setUsersIds(companyDTO.getUsers().stream()            		
                    .map(Userrecord::getId)
                    .collect(Collectors.toList()));
        }
        
        return company;
    }
	
}
