package com.loggers.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.loggers.model.Customer;
import com.loggers.repo.CustomerRepo;
import com.loggers.service.CustomerService;
/**
 * @author vinod.nagulkar
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		customerRepo.save(customer);
	}

	@Override
	public Customer loginCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerRepo.getOne(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

}
