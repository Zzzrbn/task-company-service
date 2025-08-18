package com.zzzrbn.taskcompanyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzzrbn.taskcompanyservice.entity.CompanyDTO;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTORequest;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTOResponse;
import com.zzzrbn.taskcompanyservice.service.CompanyService;
import com.zzzrbn.taskcompanyservice.service.CompanyServiceImpl;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/company")
	public ResponseEntity<List<CompanyDTOResponse>> getAllCompanies() {
		List<CompanyDTOResponse> allCompanies = companyService.getAllCompanies();
		return ResponseEntity.status(HttpStatus.OK).body(allCompanies);
	}
		
	@GetMapping("/company/{id}")
	public ResponseEntity<CompanyDTOResponse> getCompany(@PathVariable Long id) {
		CompanyDTOResponse companyDTOResponse = companyService.getCompany(id);
//		System.out.println("get company with id: " + id+ " : "+ companyDTOResponse.toString());
		return ResponseEntity.status(HttpStatus.OK).body(companyDTOResponse);
	}
		
	@PostMapping("/company")
	public ResponseEntity<CompanyDTOResponse> addNewCompany(@RequestBody CompanyDTORequest companyDTORequest)
	{
		CompanyDTOResponse companyDTOResponse = companyService.createCompany(companyDTORequest);
		//companyService.createCompany(companyDTORequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(companyDTOResponse);
		
	}
	
	@PutMapping("/company/{id}")
	public ResponseEntity<CompanyDTOResponse> updateCompany(@PathVariable Long id, @RequestBody CompanyDTORequest companyDTORequest) throws Exception
	{
		try {
			CompanyDTOResponse companyDTOResponse = companyService.updateCompany(id, companyDTORequest);
			return ResponseEntity.status(HttpStatus.OK).body(companyDTOResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	@DeleteMapping("/company/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) throws Exception
	{
		try {
		companyService.deleteCompany(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Company with id = " + id + " was deleted");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with id = " + id + "does not exist");
		}

		
	}
	

	
}
