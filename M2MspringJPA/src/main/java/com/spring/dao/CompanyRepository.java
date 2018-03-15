package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
