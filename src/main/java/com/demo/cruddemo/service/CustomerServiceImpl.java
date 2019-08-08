package com.demo.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cruddemo.dao.CustomerDAO;
import com.demo.cruddemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		return customerDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		 customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerDAO.deleteById(theId);
	}

}
