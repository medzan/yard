/**
 * 
 */
package com.doc.spring.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.doc.spring.config.ds.HIbernateConfig;
import com.doc.spring.config.ds.JdbcDataSourceConfig;

/**
 * @author Elmehdi.zangui
 *
 */
@Configuration
@ComponentScan(basePackages = "com.doc.spring")
@EnableTransactionManagement(order=10)
@Import({JdbcDataSourceConfig.class,HIbernateConfig.class})
@EnableAspectJAutoProxy
public class Application {

	@Autowired
	DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;

	// Default
	// @Bean
	// public PlatformTransactionManager platformTransactionManager() {
	// return new DataSourceTransactionManager(dataSource);
	// }
	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory);
		return manager;
	}

}