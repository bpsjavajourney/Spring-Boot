package com.app.bps.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * AppDataSource creates application data source for different profiles.
 * 
 * @author parth
 *
 */

@Configuration
public class AppDataSource {
	
	private final Logger logger=LoggerFactory.getLogger(AppDataSource.class);

	@Autowired
	private Environment env;	

	@Primary
	@Profile("dev")
	@Bean
	public DataSource devDataSource() {
		
		logger.info("####################Connecting to dev database####################");
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		datasource.setUrl(env.getProperty("spring.datasource.url"));
		datasource.setUsername(env.getProperty("spring.datasource.username"));
		datasource.setPassword(env.getProperty("spring.datasource.password"));
		
		logger.info("#################### app.custom.property:"+env.getProperty("app.custom.property")+"####################");
			
		return datasource;
	}

	@Profile("qa")
	@Bean	
	public DataSource qaDataSource() {		
		logger.info("####################Connecting to qa database####################");
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		datasource.setUrl(env.getProperty("spring.datasource.url"));
		datasource.setUsername(env.getProperty("spring.datasource.username"));
		datasource.setPassword(env.getProperty("spring.datasource.password"));
		
		logger.info("#################### app.custom.property:"+env.getProperty("app.custom.property")+"####################");
			
		return datasource;
	}

	@Profile("prod")
	@Bean	
	public DataSource prodDataSource() {	
		logger.info("####################Connecting to prod database####################");
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		datasource.setUrl(env.getProperty("spring.datasource.url"));
		datasource.setUsername(env.getProperty("spring.datasource.username"));
		datasource.setPassword(env.getProperty("spring.datasource.password"));
		
		logger.info("#################### app.custom.property:"+env.getProperty("app.custom.property")+"####################");
			
		return datasource;
	}	

}