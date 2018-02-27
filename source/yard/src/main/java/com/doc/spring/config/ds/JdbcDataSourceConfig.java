package com.doc.spring.config.ds;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
// @Profile("jdbc")
public class JdbcDataSourceConfig {

	@PostConstruct
	public void showHsqlUI() {
//			DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}
	@Bean
	public DataSource dataSource() {
		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		// dataSource.setUsername("sa");
		// dataSource.setPassword("");
		EmbeddedDatabaseBuilder buider = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase ds = buider.setType(EmbeddedDatabaseType.HSQL).build();
		return ds;
	}
}
