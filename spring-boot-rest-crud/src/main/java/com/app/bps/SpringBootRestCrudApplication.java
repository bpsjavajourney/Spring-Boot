package com.app.bps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * Spring Boot crud application main class(h2/Oracle/MySql/Postgress).
 * 
 * @author parth
 *
 */

@SpringBootApplication
public class SpringBootRestCrudApplication {
	
	private final static Logger logger=LoggerFactory.getLogger(SpringBootRestCrudApplication.class);

	public static void main(String[] args) {		
		SpringApplication.run(SpringBootRestCrudApplication.class, args);
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("Refer docs/readme.txt for the Swagger URL and Request/Response json");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}	
}
