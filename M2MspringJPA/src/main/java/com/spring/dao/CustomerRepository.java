package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByCompanyName(String name);
	
}
