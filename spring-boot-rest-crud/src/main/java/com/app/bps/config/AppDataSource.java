package com.app.bps.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import jakarta.persistence.EntityManagerFactory;


/**
 * AppDataSource creates application datasource.
 * 
 * @author parth
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager", basePackages = "com.app.bps.dao")
public class AppDataSource {
	
	private final Logger logger=LoggerFactory.getLogger(AppDataSource.class);

	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "h2DataSource")
	@Conditional(AppDataSourceCondition.H2DataSource.class)
	@ConfigurationProperties(prefix = "spring.datasource.h2")
	public DataSource h2DataSource() {		
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "oracleDataSource")
	@Conditional(AppDataSourceCondition.OracleDataSource.class)
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource oracleDataSource() {		
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "mysqlDataSource")
	@Conditional(AppDataSourceCondition.MySQLDataSource.class)
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource mysqlDataSource() {		
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "postgresqlDataSource")
	@Conditional(AppDataSourceCondition.PostgreSQLDataSource.class)
	@ConfigurationProperties(prefix = "spring.datasource.postgresql")
	public DataSource postgresqlDataSource() {		
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		String db = env.getProperty("app.datasource.enabled");		

		Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", getDialect(db));

		return builder.dataSource(getAppDatasource(db)).packages("com.app.bps.entity").persistenceUnit("bps")
				.properties(properties).build();

	}

	@Bean
	public EntityManagerFactoryBuilder EntityManagerFactoryBuilder() {
		return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManager") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);

	}

	private DataSource getAppDatasource(String db) {

		if (db.equalsIgnoreCase("oracle")) {
			logger.info("####################Connecting application database: oracle ####################");
			return oracleDataSource();
		}else if (db.equalsIgnoreCase("mysql")) {
			logger.info("####################Connecting application database: mysql ####################");
			return mysqlDataSource();
		}else if (db.equalsIgnoreCase("postgresql")) {
			logger.info("####################Connecting application database: postgresql ####################");
			return postgresqlDataSource();
		}else {
			logger.info("####################Connecting application database: h2 ####################");
			return h2DataSource();
		}

	}	

	private String getDialect(String db) {

		if (db.equalsIgnoreCase("oracle"))			
			return "org.hibernate.dialect.OracleDialect";		
		else if (db.equalsIgnoreCase("mysql"))		
			return "org.hibernate.dialect.MySQLDialect";
		else if (db.equalsIgnoreCase("postgresql")) 			
			return "org.hibernate.dialect.PostgreSQLDialect";
		else		
			return "org.hibernate.dialect.H2Dialect";
		

	}

}