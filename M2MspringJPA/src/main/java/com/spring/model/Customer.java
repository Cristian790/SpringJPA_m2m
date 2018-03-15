package com.spring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customer_id;
	private String firstname;
	private String lastname;
	private String email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="company_customer", joinColumns=@JoinColumn(name="customer_id",referencedColumnName="customer_id"),
	inverseJoinColumns=@JoinColumn(name="company_id",referencedColumnName="company_id"))
	@JsonManagedReference
	private List<Company> company;

	
	public Customer() {}
	
	public Customer(String firstname, String lastname, String email, List<Company> company) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.company = company;
	}
	
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	
	
	
	
}
