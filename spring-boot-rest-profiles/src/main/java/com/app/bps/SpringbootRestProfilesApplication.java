package com.app.bps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 
 * SpringbootRestProfilesApplication
 * 
 * @author parth
 *
 */

@SpringBootApplication
public class SpringbootRestProfilesApplication{
	
	private final static Logger logger=LoggerFactory.getLogger(SpringbootRestProfilesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestProfilesApplication.class, args);
		
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("Refer docs/readme.txt for the Swagger URL and Request/Response json");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}