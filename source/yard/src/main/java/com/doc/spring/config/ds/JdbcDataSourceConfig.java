package com.doc.spring.config.ds;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
//@Profile("jdbc")
public class JdbcDataSourceConfig  {

	@Bean
	public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
		return dataSource;
	}
}
