/**
 * 
 */
package com.doc.spring.config.ds;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author elmehdi.zangui
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.doc.spring")
@Profile("hsql")
public class DSHsqlConfig {

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
//				 .addScript("db/sql/create-db.sql")
//				 .addScript("db/sql/insert-data.sql")
				.build();
		return db;
	}

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
