package com.app.bps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 *  
 * SpringBootRedisCacheApplication
 * 
 * @author parth
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringBootRedisCacheApplication {
	
	private final static Logger logger=LoggerFactory.getLogger(SpringBootRedisCacheApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisCacheApplication.class, args);
		
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		logger.info("SpringBootRedisCacheApplication uses h2 DB and Redis Cache.");
		logger.info("Download Redis... https://redis.io/download/      or");
		logger.info("Download Redis for windows(zip)... https://github.com/microsoftarchive/redis/releases");
		logger.info("Start the Redis server and add the server credentials if required(default provided) in the YAML file");	
		logger.info("Refer docs/readme.txt for the Swagger URL and Request/Response json");
		logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}
