package com.spring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int company_id;
	private String name;
	private String email;
	
	@ManyToMany(mappedBy="company")
	private List<Customer> customer;
	
	public Company() {}

	public Company(String name, String email, List<Customer> customer) {
		super();
		this.name = name;
		this.email = email;
		this.customer = customer;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	
	
	
}
