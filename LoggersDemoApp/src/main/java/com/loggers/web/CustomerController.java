package com.loggers.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.loggers.model.Customer;
import com.loggers.service.CustomerService;

/**
 * @author vinod.nagulkar
 *
 */
@RestController
public class CustomerController 
{
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("api/customer/registerCustomer")
	void registerCustomer(@RequestBody Customer customer) 
	{
		LOGGER.info("Customer is created....");
		customerService.registerCustomer(customer);
	}
	
	@PostMapping("api/customer/loginCustomer")
	Customer loginCustomer(@RequestBody Customer customer) {
		
		LOGGER.info("Inside Customer Login API");
		return customerService.loginCustomer(customer);
		
	}
	
	@GetMapping("api/customer/getCustomer")
	Customer getCustomerById(@PathVariable Integer id) {
		
		LOGGER.info("*****ID:",id+"*******");
		return customerService.getCustomerById(id);
		
	}
	
	@GetMapping("api/customer/getAllCustomer")
	List<Customer> getAllCustomers(){
		LOGGER.info("******Inside getAllCustomers**********");
		return customerService.getAllCustomers();
		
	}
}
