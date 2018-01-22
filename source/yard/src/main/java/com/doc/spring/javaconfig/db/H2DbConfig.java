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
@Profile(ConfigConstants.H2_PROFILE)
public class H2DbConfig {

	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setName("h2DB").setType(EmbeddedDatabaseType.H2)
				.addScript(ConfigConstants.CREATE_DB_SQL).addScript(ConfigConstants.INSERT_DB_SQL).build();
		return db;
	}
	
}
