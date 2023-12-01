package com.app.bps.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

/**
 * 
 * AddressDBConfig to create datasource
 * 
 * @author parth
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.app.bps.dao.address", entityManagerFactoryRef = "addressProfileEntityManagerFactory", transactionManagerRef = "addressProfileTransactionManager")
public class AddressDBConfig {

	private Logger logger = LoggerFactory.getLogger(AddressDBConfig.class);

	/**
	 * Creates datasource
	 * 
	 * @return DataSource
	 */
	@Bean(name = "addressDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.address-db")
	public DataSource addressDataSource() {		
		return DataSourceBuilder.create().build();
	}

	/**
	 * Creates EntityManagerFactory Bean
	 * 
	 * @param builder
	 * @param addressDataSource
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean(name = "addressProfileEntityManagerFactory")
	@Qualifier("addressProfileEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("addressEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
			@Qualifier("addressDataSource") DataSource addressDataSource) {

		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		return builder.dataSource(addressDataSource).packages("com.app.bps.entity.address")
				.persistenceUnit("addressUnit").properties(properties).build();

	}

	/**
	 * Creates EntityManagerFactoryBuilder
	 * 
	 * @return EntityManagerFactoryBuilder
	 */
	@Bean(name = "addressEntityManagerFactoryBuilder")
	@Qualifier("addressEntityManagerFactoryBuilder")
	public EntityManagerFactoryBuilder EntityManagerFactoryBuilder() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	/**
	 * Creates TransactionManager
	 * 
	 * @param entityManagerFactory
	 * @return PlatformTransactionManager
	 */
	@Bean(name = "addressProfileTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("addressProfileEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		PlatformTransactionManager transactionmanager = new JpaTransactionManager(entityManagerFactory);

		logger.info("####################address-db connection established successfully.####################");

		return transactionmanager;

	}

}
