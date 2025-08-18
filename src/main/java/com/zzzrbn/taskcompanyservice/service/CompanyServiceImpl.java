package com.zzzrbn.taskcompanyservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.zzzrbn.taskcompanyservice.client.Feignuser;
import com.zzzrbn.taskcompanyservice.dao.CompanyDAO;
import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;
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
		log.info("Get all companies");
		Pageable pageable = PageRequest.of(page, size);
		Page<Company> cPage = companyDAO.findAll(pageable);
		List<Company> cList = cPage.getContent();
		List<CompanyDTOResponse> companyDTOResponses = new ArrayList<>();
		for (Company c : cList) {
			CompanyDTOResponse companyDTOResponse = companyMapper.companyToCompanyResponse(c);
			List<Userrecord> userrecords = feignuser.findByCompanyId(c.getId());
			if (userrecords != null) {
				companyDTOResponse.setUsers(userrecords);
			}
			companyDTOResponses.add(companyDTOResponse);
		}
		return companyDTOResponses;
	}

	@Transactional
	public CompanyDTOResponse createCompany(CompanyDTORequest companyDTORequest) {
		log.info("Creating new company: {}", companyDTORequest);
		Company company = companyMapper.companyrequestToCompany(companyDTORequest);
		companyDAO.save(company);
		return companyMapper.companyToCompanyResponse(company);
	}

	@Transactional
	public CompanyDTOResponse getCompany(Long id) {
		log.info("Get company by id: {}", id);
		Optional<Company> company = companyDAO.findById(id);
		CompanyDTOResponse companyDTOResponse = companyMapper.companyToCompanyResponse(company.get());
		List<Userrecord> userrecords = feignuser.findByCompanyId(company.get().getId());
		if (userrecords != null) {
			companyDTOResponse.setUsers(userrecords);
		}
		return companyDTOResponse;
	}

	@Transactional
	public void deleteCompany(Long id) throws Exception {
		log.info("Deleting company with id: {}", id);
		if (!companyDAO.existsById(id)) {
			throw new Exception("Company with id " + id + " does not exist");
		}
		companyDAO.deleteById(id);
		List<Userrecord> userrecords = feignuser.findByCompanyId(id);
		if (userrecords != null && !userrecords.isEmpty()) {
			for (Userrecord ur : userrecords) {
				ur.setCompanyId(null);
				feignuser.updateUserrecord(ur.getId(), ur);
			}
		}
	}

	@Transactional
	public CompanyDTOResponse updateCompany(Long id, CompanyDTORequest companyDTORequest) throws Exception {
		log.info("Updating company with id {}: {}", id, companyDTORequest);
		Optional<Company> company;
		if (companyDAO.existsById(id)) {
			company = companyDAO.findById(id);
			companyMapper.updateCompany(company.get(), companyDTORequest);
			companyDAO.save(company.get());
		} else {
			throw new Exception("Company with id: " + id + " is not exist");
		}
		return companyMapper.companyToCompanyResponse(company.get());
	}

}
