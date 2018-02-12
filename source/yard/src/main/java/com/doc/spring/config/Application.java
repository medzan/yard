/**
 * 
 */
package com.doc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.doc.spring.bean.SimpleBean;

/**
 * @author Elmehdi.zangui
 *
 */
@Configuration
@ComponentScan(basePackages = "com.doc.spring")
// @Profile("default")
@PropertySource("classpath:main.properties")
// @Import(DSHsqlConfig.class)
public class Application {

	@Bean
	public PropertySourcesPlaceholderConfigurer oropertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer ps = new PropertySourcesPlaceholderConfigurer();
		return ps;
	}

	@Bean
	public SimpleBean simpleBean() {
		return new SimpleBean("Application");
	}

}
