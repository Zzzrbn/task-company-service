package com.zzzrbn.taskcompanyservice.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zzzrbn.taskcompanyservice.client.Feignuser;
import com.zzzrbn.taskcompanyservice.dao.CompanyDAO;
import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;
import com.zzzrbn.taskcompanyservice.exception.EntityNotFoundException;
import com.zzzrbn.taskcompanyservice.mappers.CompanyMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

	private final CompanyDAO companyDAO;

	private final Feignuser feignuser;

	private final CompanyMapper companyMapper;

	public List<CompanyDTOResponse> getAllCompanies(int page, int size) {
		log.info("Returning all companies: page = {}, size = {}", page, size);
		return companyMapper.companyListToCompanyDTOResponses(paginatedCompanies(page, size), feignuser);
	}

	@Transactional
	public CompanyDTOResponse createCompany(CompanyDTORequest companyDTORequest) {
		Company company = companyMapper.companyrequestToCompany(companyDTORequest);
		Company savedCompany = companyDAO.save(company);
		log.info("Created new company: {}", savedCompany);
		return companyMapper.companyToCompanyResponse(savedCompany);
	}

	public CompanyDTOResponse getCompany(Long id) {
		Company company = companyDAO.findById(id)
				.orElseThrow(()-> new EntityNotFoundException("Company", id));
		CompanyDTOResponse companyDTOResponse = companyMapper.companyToCompanyResponse(company);
		companyDTOResponse.setUsers(feignuser.findByCompanyId(company.getId()));
		log.info("Returned company by id = {}", id);
		return companyDTOResponse;
	}

	@Transactional
	public void deleteCompany(Long id) {
		if (companyDAO.existsById(id)) {
			deleteCompanyIdFromUserrecords(id);
			companyDAO.deleteById(id);
			log.info("Company with id = {} removed", id);
		}
		else {
			throw new EntityNotFoundException("Company", id);
		}
	}

	@Transactional
	public CompanyDTOResponse updateCompany(Long id, CompanyDTORequest companyDTORequest) {
		Company company = companyDAO.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Company", id));
		companyMapper.updateCompany(company, companyDTORequest);
		Company updatedCompany = companyDAO.save(company);
		log.info("Updated company with id {}", id);
		return companyMapper.companyToCompanyResponse(updatedCompany);
	}


	private List<Company> paginatedCompanies(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Company> cPage = companyDAO.findAll(pageable);
		return cPage.getContent();
	}

	private void deleteCompanyIdFromUserrecords(Long id) {
		feignuser.removeCompanyIdFromUsers(id);
		log.info("CompanyId  = {}  deleted from all users", id);
	}

}
