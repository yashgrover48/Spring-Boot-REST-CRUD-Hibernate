package com.demo.cruddemo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cruddemo.entity.Customer;
import com.demo.cruddemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	// expose "/customers" to get all the customers
	@GetMapping("/customers")
	public List<Customer> findAll(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable int id){
		Customer customer = customerService.findById(id);
		if(customer == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		return customer;
	}
	
	@PostMapping("/create")
	public void createCustomer(@RequestBody Customer customer){
		customerService.save(customer);
	}
	
	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer customer){
		customerService.save(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomerById(@PathVariable int id){
		Customer customer = customerService.findById(id);
		if(customer == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		customerService.deleteById(id);
	}
}
