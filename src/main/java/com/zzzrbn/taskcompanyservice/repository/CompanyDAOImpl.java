package com.zzzrbn.taskcompanyservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zzzrbn.taskcompanyservice.controller.Feignuser;
import com.zzzrbn.taskcompanyservice.dao.CompanyDAO;
import com.zzzrbn.taskcompanyservice.entity.Company;
import com.zzzrbn.taskcompanyservice.entity.CompanyDTO;
import com.zzzrbn.taskcompanyservice.entity.Userrecord;
import com.zzzrbn.taskcompanyservice.mappers.CompanyMapper;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

//@Repository
//@RequiredArgsConstructor
public class CompanyDAOImpl 
//implements CompanyDAO 
{

//	@Autowired
//	private EntityManager entityManager;
	
//  private final Feignuser userServiceClient;
//
//  @Autowired
//  public public public CompanyDAOImpl(Feignuser userServiceClient) {
//      this.userServiceClient = userServiceClient;
//  }
	
	
//	private final CompanyMapper companyMapper;
//
//	
//	@Override
//	public List<CompanyDTO> getAllCompanies() {
//		Session session = entityManager.unwrap(Session.class);
//		Query<Company> query = session.createQuery("from Company", Company.class);
//		List<Company> allCompanies = query.getResultList();
//		List<CompanyDTO> allCompanyDTOs = new ArrayList<>();
//		for (Company company : allCompanies)
//		{
//			Query<Userrecord> query1 = session.createQuery("from Userrecord where companyId =: company_id", Userrecord.class);
//			query1.setParameter("company_id", company.getId());
//			List<Userrecord> userrecords = query1.getResultList();
//			company.setUsers(userrecords);
//			allCompanyDTOs.add(companyMapper.toDTO(company, userrecords));
//		}
//		
//		return allCompanyDTOs;
//	}
//
//	@Override
//	public void createCompany(CompanyDTO companyDTO) {
//		Session session = entityManager.unwrap(Session.class);
//		
//		Company company = companyMapper.toEntity(companyDTO);
//		Query<Userrecord> query = session.createQuery("from Userrecord where companyId =: company_id", Userrecord.class);
//		query.setParameter("company_id", company.getId());
//		List<Userrecord> userrecords = query.getResultList();
//		company.setUsers(userrecords);
//		session.persist(company);
//	}
//
//	@Override
//	public CompanyDTO getCompany(Long id) {
//		Session session = entityManager.unwrap(Session.class);
//		Company company = session.get(Company.class, id);
//		Query<Userrecord> query = session.createQuery("from Userrecord where companyId =: company_id", Userrecord.class);
//		query.setParameter("company_id", company.getId());
//		List<Userrecord> userrecords = query.getResultList();
//		CompanyDTO companyDTO = companyMapper.toDTO(company, userrecords);
//		return companyDTO;
//	}
//	
//	@Override
//	public Company getCompanybyID(Long id) {
//		Session session = entityManager.unwrap(Session.class);
//		Company company = session.get(Company.class, id);
//		return company;
//	}
//
//	@Override
//	public void deleteCompany(Long id) throws Exception {
//		
//		CompanyDTO companyDTO = getCompany(id);
//		if (companyDTO == null)
//		{
//			throw new Exception("There is no company with id = "+id+" in Database");
//		}
//		
//		Session session = entityManager.unwrap(Session.class);
//		session.remove(session.get(Company.class, id));
//		
//	}
//
//	@Override
//	public void updateCompany(Long id, CompanyDTO companyDTO) {
//		Session session = entityManager.unwrap(Session.class);
//		Company company = session.get(Company.class, id);
//		company.setBudget(companyDTO.getBudget());
//		company.setName(companyDTO.getName());
//		company.setUsers(companyDTO.getUsers());
//	}
//	

}
