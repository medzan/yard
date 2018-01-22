/**
 * 
 */
package com.doc.spring.javaconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Elmehdi.zangui
 *
 */
@Configuration
@ComponentScan(basePackages = "com.doc.spring")
@PropertySource("classpath:app/app.properties")
public class Application {

	@Bean
	@Scope("prototype")
	public Logger logger(DependencyDescriptor injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
