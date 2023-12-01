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
 * PersonDBConfig to create datasource
 * 
 * @author parth
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.app.bps.dao.person", entityManagerFactoryRef = "personProfileEntityManagerFactory", transactionManagerRef = "personProfiletransactionManager")
public class PersonDBConfig {

	private Logger logger = LoggerFactory.getLogger(PersonDBConfig.class);

	/**
	 * Creates datasource
	 * 
	 * @return DataSource
	 */
	@Bean(name = "personDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.person-db")
	public DataSource personDataSource() {		
		return DataSourceBuilder.create().build();
	}

	/**
	 * Creates EntityManagerFactory Bean
	 * 
	 * @param builder
	 * @param personDataSource
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean(name = "personProfileEntityManagerFactory")
	@Qualifier("personrProfileEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("personEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder,
			@Qualifier("personDataSource") DataSource personDataSource) {

		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		return builder.dataSource(personDataSource).packages("com.app.bps.entity.person").persistenceUnit("personUnit")
				.properties(properties).build();

	}

	/**
	 * Creates EntityManagerFactoryBuilder
	 * 
	 * @return EntityManagerFactoryBuilder
	 */
	@Bean(name = "personEntityManagerFactoryBuilder")
	@Qualifier("personEntityManagerFactoryBuilder")
	public EntityManagerFactoryBuilder EntityManagerFactoryBuilder() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	/**
	 * Creates TransactionManager
	 * 
	 * @param entityManagerFactory
	 * @return PlatformTransactionManager
	 */
	@Bean(name = "personProfiletransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("personrProfileEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		PlatformTransactionManager transactionmanager = new JpaTransactionManager(entityManagerFactory);

		logger.info("####################person-db connection established successfully.####################");

		return transactionmanager;

	}

}
