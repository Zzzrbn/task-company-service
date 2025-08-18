package com.zzzrbn.taskcompanyservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTO;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;

@Service
public interface CompanyService {

	public List<CompanyDTOResponse> getAllCompanies();
	
	public CompanyDTOResponse createCompany(CompanyDTORequest companyDTORequest);
	
	public CompanyDTOResponse getCompany (Long id);
	
//	public CompanyDTOResponse getCompanybyId (Long id);
	
	public void deleteCompany(Long id) throws Exception;
	
	public CompanyDTOResponse updateCompany(Long id, CompanyDTORequest companyDTORequest) throws Exception;
	
}
