package com.doc.spring;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.doc.spring.custom.ValidatorServices;
import com.doc.spring.custom.pojo.SimplePojo;
import com.doc.spring.javaconfig.Application;

public class ValidatorsTests {

	@Test
	public void validatorsInjectionXmlTests() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		ValidatorServices validatorServices = context.getBean(ValidatorServices.class);
		Assert.assertNotNull(validatorServices.getJavaxValidator());
		// Assert.assertNotNull(validatorServices.getJavaxValidator());
		// Assert.assertNotNull(validatorServices.getValidatorFactory());

	}
	@Test
	public void validatorsInjectionJavaTests() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		ValidatorServices validatorServices = context.getBean(ValidatorServices.class);
		Assert.assertNotNull(validatorServices.getJavaxValidator());
		 Assert.assertNotNull(validatorServices.getJavaxValidator());
		 Assert.assertNotNull(validatorServices.getValidatorFactory());
		 SimplePojo bean = context.getBean(SimplePojo.class);
		 BeanPropertyBindingResult errors = new BeanPropertyBindingResult(bean, "simplePojo");
		validatorServices.getSpringValidator().validate(bean, errors);
		Assert.assertEquals(1, errors.getErrorCount());
		errors.getAllErrors().forEach(e ->  System.out.println(context.getMessage(e, Locale.FRENCH)));
	}
}
