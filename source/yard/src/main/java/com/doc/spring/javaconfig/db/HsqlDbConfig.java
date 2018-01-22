package com.doc.spring.javaconfig.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import com.doc.spring.config.ConfigConstants;
import com.doc.spring.javaconfig.annotations.HSqlProfile;

@Component
@HSqlProfile
public class HsqlDbConfig {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setName("hsqlDB").setType(EmbeddedDatabaseType.HSQL)
				.addScript(ConfigConstants.CREATE_DB_SQL).addScript(ConfigConstants.INSERT_DB_SQL).build();
		return db;
	}
}
