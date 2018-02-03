/**
 * 
 */
package com.doc.spring.javaconfig;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

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
	 @Bean(name="springValidator")
	 public LocalValidatorFactoryBean validator() {
		 return new LocalValidatorFactoryBean();
	 }
	 @Bean
		public MessageSource messageSource () {
			ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
			ms.setBasenames("exception");
			ms.setFallbackToSystemLocale(false);
			return ms;
		}
	 
//	 @Bean
//	 public MethodValidationPostProcessor methodValidationPostProcessor() {
//		return new MethodValidationPostProcessor(); 
//	 }
	 
}
