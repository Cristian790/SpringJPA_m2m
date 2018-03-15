package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	List<Company> findByCustomerFirstnameAndCustomerLastname(String firstname,String lastname);
}
