package com.loggers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.loggers.model.Customer;

/**
 * @author vinod.nagulkar
 *
 */
@Service
public interface CustomerService 
{
	void registerCustomer(Customer customer);
	Customer loginCustomer(Customer customer);
	Customer getCustomerById(Integer id);
	List<Customer>getAllCustomers();
}
