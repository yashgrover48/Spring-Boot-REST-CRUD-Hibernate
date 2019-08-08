package com.demo.cruddemo.dao;

import java.util.List;

import com.demo.cruddemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);

}
