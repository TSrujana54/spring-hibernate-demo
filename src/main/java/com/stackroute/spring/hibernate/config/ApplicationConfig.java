package com.stackroute.spring.hibernate.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.stackroute.spring.hibernate.entity.Employee;

@Configuration
@EnableTransactionManagement
public class ApplicationConfig {
	
//	Beans configuration required for Hibernate
	/*
	 * Hibernate uses this DataSource configuration to automatically connect to database 
	 */
	@Bean	
	public DataSource getDataSource() {
		/*
		 * Driver ( com.mysql.jdbc.Driver)
		 * URL ( jdbc:mysql://localhost:3306/dbname)
		 * Credentials -> username, password
		 */
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/empdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	
	@Bean	
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) throws IOException{
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "create");
		sessionFactoryBean.setAnnotatedClasses(new Class[] {Employee.class });
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean;
	}
	
	
	@Bean	
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(sessionFactory);
		return transaction;
	}



}
