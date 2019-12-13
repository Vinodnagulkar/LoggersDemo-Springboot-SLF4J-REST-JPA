package com.loggers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loggers.model.Customer;

/**
 * @author vinod.nagulkar
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	Customer findByLoginNameAndPassword(String username, String password);
}
