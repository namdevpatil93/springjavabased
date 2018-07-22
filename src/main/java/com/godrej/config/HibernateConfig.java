package com.godrej.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	public DataSource  dataSource()
	{
		JndiDataSourceLookup dsLookup=new JndiDataSourceLookup();
		 DataSource dataSource = dsLookup.getDataSource("jdbc/triton");
		return dataSource;
	}
	public Properties getProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] {"com.godrej.entity"});
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(getProperties());
		em.setPersistenceUnitName("default");
		return em;
	}
	
	public DataSource  dataSourcetwo()
	{
		JndiDataSourceLookup dsLookup=new JndiDataSourceLookup();
		 DataSource dataSource = dsLookup.getDataSource("jdbc/root");
		return dataSource;
	}
	
	public Properties getPropertiestwo()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		return properties;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactorytwo()
	{
		LocalContainerEntityManagerFactoryBean em=new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSourcetwo());
		em.setPackagesToScan(new String[] {"com.godrej.entity"});
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(getPropertiestwo());
		em.setPersistenceUnitName("root");
		return em;
	}
	
	
	@Bean
	@Autowired
	@Qualifier
	public PlatformTransactionManager transactionManagertwo() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactorytwo().getObject());
		return transactionManager;
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager() {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
 