package com.demo.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.cruddemo.entity.Customer;

//TODO Auto-generated method stub

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	//define field for Entity Manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//execute query and get result list
		List<Customer> customer = theQuery.getResultList();
		
		return customer;
	}

	@Override
	public Customer findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customer = currentSession.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void save(Customer theCustomer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customer = currentSession.get(Customer.class, theId);
		currentSession.delete(customer);
	}

}
