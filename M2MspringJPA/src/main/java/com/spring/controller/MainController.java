package com.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.dao.CompanyRepository;
import com.spring.dao.CustomerRepository;
import com.spring.model.Company;
import com.spring.model.Customer;

@Controller
public class MainController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@RequestMapping("/customer/{name}")
	public @ResponseBody Iterable<Customer> findAll(@PathVariable (value="name") String name){
		return customerRepository.findByCompanyName(name); 
	}
	
	@RequestMapping("/customer/id/{id}")
	public @ResponseBody Customer findOne(@PathVariable (value="id") int id){
		return customerRepository.findOne(id); 
	}
	
	
	@RequestMapping("/customer")
	public @ResponseBody Iterable<Customer> findAllCustomers(){
		return customerRepository.findAll(); 
	}
	
	@RequestMapping("/company")
	public @ResponseBody Iterable<Company> findAllCompanies(){
		return companyRepository.findAll(); 
	}
	
	@RequestMapping("/companyList/")
	public @ResponseBody Iterable<Company> companyList(@RequestParam String firstname,@RequestParam String lastname){
		return companyRepository.findByCustomerFirstnameAndCustomerLastname(firstname, lastname); 
	}
	
	@RequestMapping("/addCustomer")
	public @ResponseBody Iterable<Customer> addCustomer
									(@RequestParam String firstname,
									 @RequestParam String lastname,
									 @RequestParam String email,
									 @RequestParam int id)
	{
		
		List<Company> companies= new ArrayList<>();
		companies.add(companyRepository.findOne(id));
		Customer customer=new Customer(firstname,lastname,email,companies);
		customerRepository.save(customer);
		return customerRepository.findAll();
	}
}
