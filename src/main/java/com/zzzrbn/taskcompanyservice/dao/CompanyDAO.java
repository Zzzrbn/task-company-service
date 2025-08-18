package com.zzzrbn.taskcompanyservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zzzrbn.taskcompanyservice.entity.Company;

public interface CompanyDAO extends JpaRepository<Company, Long> {
}
