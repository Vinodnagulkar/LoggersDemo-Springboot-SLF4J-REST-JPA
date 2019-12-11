package com.loggers.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(MainApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		LOGGER.info("Your application is started!");
	}

}
