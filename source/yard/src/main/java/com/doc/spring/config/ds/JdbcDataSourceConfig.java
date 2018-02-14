package com.doc.spring.config.ds;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("jdbc")
public class JdbcDataSourceConfig  {

	public DataSource dataSource() {
		
		return null;
	}
}
