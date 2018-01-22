package com.doc.spring.javaconfig.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import com.doc.spring.config.ConfigConstants;

@Component
@Profile(ConfigConstants.DERBY_PROFILE)
public class DerbyDbConfig {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setName("derbyDb").setType(EmbeddedDatabaseType.DERBY)
				.addScript(ConfigConstants.CREATE_DB_SQL).addScript(ConfigConstants.INSERT_DB_SQL).build();
		return db;
	}
}
