package com.zzzrbn.taskcompanyservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;

@Service
public interface CompanyService {

	public List<CompanyDTOResponse> getAllCompanies(int page, int size);
	
	public CompanyDTOResponse createCompany(CompanyDTORequest companyDTORequest);
	
	public CompanyDTOResponse getCompany (Long id);
	
	public void deleteCompany(Long id);
	
	public CompanyDTOResponse updateCompany(Long id, CompanyDTORequest companyDTORequest);
	
}
