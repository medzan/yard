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
 * @author Elmehdi.zangui
 *
 */
@Configuration
@ComponentScan(basePackages = "com.doc.spring")
@Profile("default")
public class Application {

	@Bean
	public SimpleBean simpleBean() {
		return new SimpleBean("default");
	}

}