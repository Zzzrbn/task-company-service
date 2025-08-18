package com.zzzrbn.taskcompanyservice.mappers;

import org.springframework.stereotype.Component;

import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;

@Component
public class CompanyMapper {

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
		return response;
	}

	public void updateCompany(Company company, CompanyDTORequest companyDTORequest) {
		company.setName(companyDTORequest.getName());
		company.setBudget(companyDTORequest.getBudget());
		company.setUsersIds(companyDTORequest.getUserrecordIds());
	}

}
