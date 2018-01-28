/**
 * 
 */
package com.doc.spring.javaconfig;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;
import org.springframework.format.datetime.standard.DateTimeFormatterFactoryBean;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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

//	@Bean
//	public ConversionService conversionService() {
//		return new DefaultConversionService();
//	}
	 @Bean
	    public DefaultFormattingConversionService conversionService() {

	        // Use the DefaultFormattingConversionService but do not register defaults
	        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);
	        
	        // Ensure @NumberFormat is still supported
	        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());
	        conversionService.addFormatterForFieldType(Date.class, new DateFormatter("yyyyMMdd"));
	        
//	        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
//	        registrar.setFormatter(new DateFormatter("yyyyMMdd"));
//	        registrar.registerFormatters(conversionService);
	        return conversionService;
	    }
	 @Bean
	 public LocalValidatorFactoryBean validator() {
		 return new LocalValidatorFactoryBean();
	 }
}
