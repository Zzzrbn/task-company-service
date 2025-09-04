package com.zzzrbn.taskcompanyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;
import com.zzzrbn.taskcompanyservice.service.CompanyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping("/company")
	public List<CompanyDTOResponse> getAllCompanies(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		log.info("Getting all companies (page= {}, size={})", page, size);
		List<CompanyDTOResponse> allCompanies = companyService.getAllCompanies(page, size);
		return allCompanies;
	}

	@GetMapping("/company/{id}")
	public CompanyDTOResponse getCompany(@PathVariable Long id) {
		log.info("Getting company with id = {}", id);
		CompanyDTOResponse companyDTOResponse = companyService.getCompany(id);
		return companyDTOResponse;
	}

	@PostMapping("/company")
	public CompanyDTOResponse addNewCompany(@RequestBody @Valid CompanyDTORequest companyDTORequest) {
		log.info("Adding new company: {}", companyDTORequest.toString());
		CompanyDTOResponse companyDTOResponse = companyService.createCompany(companyDTORequest);
		return companyDTOResponse;
	}

	@PutMapping("/company/{id}")
	public CompanyDTOResponse updateCompany(@PathVariable Long id,
			@RequestBody @Valid CompanyDTORequest companyDTORequest) {
		log.info("Updating company with id = {} : {}", id, companyDTORequest.toString());
		CompanyDTOResponse companyDTOResponse = companyService.updateCompany(id, companyDTORequest);
		return companyDTOResponse;		
	}

	@DeleteMapping("/company/{id}")
	public String deleteCompany(@PathVariable Long id) {		
		log.info("Deleting company with id = {}", id);
		companyService.deleteCompany(id);
		return "Company with id = " + id + " was deleted";
	}	
}
