package com.zzzrbn.taskcompanyservice.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTO;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;

@Component
public class CompanyMapper {

    public CompanyDTO toDTO(Company company, List<Userrecord> userrecords) {
        if (company == null) {
            return null;
        }
        
        CompanyDTO dto = new CompanyDTO();
//        dto.setId(company.getId());
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
//        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setBudget(companyDTO.getBudget());
        
        if (companyDTO.getUsers() != null) {
            company.setUsersIds(companyDTO.getUsers().stream()            		
                    .map(Userrecord::getId)
                    .collect(Collectors.toList()));
        }
        
        return company;
    }
    
    public Company companyrequestToCompany(CompanyDTORequest companyDTORequest) {
        Company company = new Company();
        company.setName(companyDTORequest.getName());
        company.setBudget(companyDTORequest.getBudget());
        company.setUsersIds(companyDTORequest.getUserrecordIds());
        return company;
    }

    public CompanyDTOResponse companyToCompanyResponse(Company company) {
        CompanyDTOResponse response = new CompanyDTOResponse();
        response.setId(company.getId());
        response.setName(company.getName());
        response.setBudget(company.getBudget());
        response.setUsers(company.getUserrecords());
        // Fetch user details from user-service
//        try {
//            if (company.getEmployeeIds() != null && !company.getEmployeeIds().isEmpty()) {
//                List<User> employees = userClient.getUsersByCompanyId(company.getId());
//                response.setEmployees(employees);
//            } else {
//                response.setEmployees(List.of());
//            }
//        } catch (Exception e) {
//            log.error("Error fetching user details for companyId: {}", company.getId(), e);
//            response.setEmployees(List.of());
//        }
        
        return response;
    }
    
    public void updateCompany(Company company, CompanyDTORequest companyDTORequest)
    {
    	company.setName(companyDTORequest.getName());
		company.setBudget(companyDTORequest.getBudget());
		company.setUsersIds(companyDTORequest.getUserrecordIds());
    }
    
	
}
