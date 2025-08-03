package com.zzzrbn.taskcompanyservice.dao;

import java.util.List;

import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTO;

public interface CompanyDAO {
	
	public List<CompanyDTO> getAllCompanies();
	
	public void createCompany(CompanyDTO companyDTO);
	
	public CompanyDTO getCompany (Long id);
	
	public void deleteCompany(Long id);
	
	public void updateCompany(Long id, CompanyDTO companyDTO);

	public Company getCompanybyID(Long id);

}
