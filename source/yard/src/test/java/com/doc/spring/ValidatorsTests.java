package com.doc.spring;

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
		 Errors errors = new BeanPropertyBindingResult(bean, "simplePojo");
		validatorServices.getSpringValidator().validate(bean, errors);
		System.out.println(errors);
		Assert.assertEquals(0, errors.getErrorCount());
	}
}
