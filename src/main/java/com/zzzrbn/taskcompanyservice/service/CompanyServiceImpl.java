package com.zzzrbn.taskcompanyservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zzzrbn.taskcompanyservice.client.Feignuser;
import com.zzzrbn.taskcompanyservice.dao.CompanyDAO;
import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;
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

	@Transactional
	public List<CompanyDTOResponse> getAllCompanies(int page, int size) {
		log.info("Returning all companies: page = {}, size = {}", page, size);
		return companyMapper.companyListToCompanyDTOResponses(paginatedCompanies(page, size), feignuser);
	}

	@Transactional
	public CompanyDTOResponse createCompany(CompanyDTORequest companyDTORequest) {
		Company company = companyMapper.companyrequestToCompany(companyDTORequest);
		companyDAO.save(company);
		log.info("Created new company: {}", companyDTORequest);
		return companyMapper.companyToCompanyResponse(company);
	}

	@Transactional
	public CompanyDTOResponse getCompany(Long id) {
		Optional<Company> company = companyDAO.findById(id);
		CompanyDTOResponse companyDTOResponse = companyMapper.companyToCompanyResponse(company.get());
		companyDTOResponse.setUsers(feignuser.findByCompanyId(company.get().getId()));
		log.info("Returned company by id = {} : {}", id, companyDTOResponse.toString());
		return companyDTOResponse;
	}

	@Transactional
	public void deleteCompany(Long id) {
		if (existCompanyWithId(id)) {
			companyDAO.deleteById(id);
			deleteCompanyIdFromUserrecords(id);
			log.info("Company with id = {} removed", id);
		}
	}

	@Transactional
	public CompanyDTOResponse updateCompany(Long id, CompanyDTORequest companyDTORequest) {
		Optional<Company> company = java.util.Optional.empty();
		if (existCompanyWithId(id)) {
			company = companyDAO.findById(id);
			companyMapper.updateCompany(company.get(), companyDTORequest);
			companyDAO.save(company.get());
			log.info("Updated company with id {}: {}", id, company.get().toString());
		}

		return companyMapper.companyToCompanyResponse(company.get());
	}

	private boolean existCompanyWithId(Long id) {
		if (!companyDAO.existsById(id)) {
			throw new EntityNotFoundException("Company", id);
		}
		return true;
	}

	private List<Company> paginatedCompanies(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Company> cPage = companyDAO.findAll(pageable);
		List<Company> cList = cPage.getContent();
		log.info("Returned paginated list of companies: {}", cList.toString());
		return cList;
	}

	private void deleteCompanyIdFromUserrecords(Long id) {
		List<Userrecord> userrecords = feignuser.findByCompanyId(id);
		if (userrecords != null && !userrecords.isEmpty()) {
			for (Userrecord ur : userrecords) {
				ur.setCompanyId(null);
				feignuser.updateUserrecord(ur.getId(), ur);
			}
		}
		log.info("CompanyId  = {}  deleted from all users", id);
	}

}
