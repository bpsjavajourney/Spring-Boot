package com.app.bps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * SpringBootRestMultidbApplication
 * 
 * @author parth
 *
 */
@SpringBootApplication
public class SpringBootRestMultidbApplication {

	private final static Logger logger = LoggerFactory.getLogger(SpringBootRestMultidbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestMultidbApplication.class, args);

		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("Go to aplication.yaml file to make datasource changes.");
		logger.info("The purpose of the application is only to connect to multiple databases and insert/retrieve data.");
		logger.info("Refer docs/readme.txt for the Swagger URL and Request/Response json");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}
