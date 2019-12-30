package com.loggers.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loggers.exceptions.USERNOTFOUNDEXCEPTION;
import com.loggers.model.Customer;
import com.loggers.service.CustomerService;
import com.loggers.util.LoggersURI;

/**
 * @author vinod.nagulkar
 */
@RestController
public class CustomerController 
{
	
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping(LoggersURI.REGISTER_CUSTOMER)
	ResponseEntity<?> registerCustomer(@RequestBody Customer customer) 
	{
		customerService.registerCustomer(customer);
		LOGGER.info("Customer is created....");
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
		
	}
	
	@PostMapping(LoggersURI.LOGIN_CUSTOMER)
	ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) throws USERNOTFOUNDEXCEPTION {
		
		LOGGER.info("Inside Customer Login API");
	 Customer cust=customerService.loginCustomer(customer);
	 if(cust!=null)
		 return new ResponseEntity<Customer>(cust,HttpStatus.ACCEPTED);
	 else
		 return new ResponseEntity<Customer>(HttpStatus.FORBIDDEN);
		
	}
	
	@GetMapping(LoggersURI.GET_CUSTOMER)
	ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
		
		LOGGER.info("*****ID:",id+"*******");
		Customer cust=customerService.getCustomerById(id);
		LOGGER.info("Customer:"+cust);
		if(cust!=null)
			return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
		else 
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(LoggersURI.GET_ALL_CUSTOMER)
	ResponseEntity<?> getAllCustomers(){
		LOGGER.info("******Inside getAllCustomers**********");
		List<Customer>customerList=customerService.getAllCustomers();
		if(!customerList.isEmpty())
			return new ResponseEntity<Customer>((Customer) customerList,HttpStatus.OK);
		else
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
				
	}
}
