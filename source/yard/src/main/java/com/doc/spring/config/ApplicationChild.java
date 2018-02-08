/**
 * 
 */
package com.doc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.doc.spring.bean.SimpleBean;

/**
 * @author elmehdi.zangui
 *
 */
@Configuration
@ComponentScan(basePackages = "com.doc.spring")
@Profile("default")
@PropertySource("classpath:main.properties")
public class ApplicationChild {
	@Bean
	public SimpleBean simpleBean() {
		return new SimpleBean("default");
	}
}
