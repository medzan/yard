/**
 * 
 */
package com.doc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.doc.spring.bean.SimpleBean;

/**
 * @author elmehdi.zangui Not for prod really
 */
@Configuration
@ComponentScan(basePackages = "com.doc.spring")
@Profile("PROD")
public class ApplicationProd {
	@Bean
	public SimpleBean simpleBean() {
		return new SimpleBean("PROD");
	}
}
