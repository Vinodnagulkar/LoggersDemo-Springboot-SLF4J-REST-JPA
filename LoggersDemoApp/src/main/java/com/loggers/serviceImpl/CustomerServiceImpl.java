package com.loggers.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loggers.exceptions.USERNOTFOUNDEXCEPTION;
import com.loggers.model.Customer;
import com.loggers.repo.CustomerRepo;
import com.loggers.service.CustomerService;
/**
 * @author vinod.nagulkar
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
		LOGGER.info("Customer registered with: "+ customer);
	}

	@Override
	public Customer loginCustomer(Customer customer) throws USERNOTFOUNDEXCEPTION {
		// TODO Auto-generated method stub
		
		Customer logincust = customerRepo.findByLoginNameAndPassword(customer.getLoginName(),customer.getPassword());
		if(logincust==null) 
		{
			LOGGER.error("****Login Failed!*****");
		 	throw new USERNOTFOUNDEXCEPTION("User Not Found!");
		}else
			LOGGER.info("***Login Success",logincust);
			return logincust;
	}
	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.getOne(id);
		if(customer==null)
			LOGGER.error("***Customer not Found of this ID!*****");
		else
			LOGGER.info("\n\n********Customer:"+customer+"**************\n\n");
			return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
