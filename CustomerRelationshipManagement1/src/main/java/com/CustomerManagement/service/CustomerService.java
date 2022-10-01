package com.CustomerManagement.service;

import java.util.List;

import com.CustomerManagement.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);

}
