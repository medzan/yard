package com.doc.spring;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.doc.spring.custom.SimplePojoValidator;
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
	public void validatorsInjectionSimpleJavaTests() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		// System.out.println(context.getMessage("NotNull.simplePojo.name", null
		// ,Locale.US));

		ValidatorServices validatorServices = context.getBean(ValidatorServices.class);
		SimplePojoValidator simplePojoValidator = validatorServices.getSimplePojoValidator();
		SimplePojo bean = context.getBean(SimplePojo.class);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(bean, "simplePojo");
		DefaultMessageCodesResolver messageCodesResolver = (DefaultMessageCodesResolver) errors
				.getMessageCodesResolver();
		messageCodesResolver.setMessageCodeFormatter(DefaultMessageCodesResolver.Format.POSTFIX_ERROR_CODE);
		// validatorServices.getSpringValidator().validate(bean, errors);
		ValidationUtils.invokeValidator(simplePojoValidator, bean, errors);
		Assert.assertEquals(1, errors.getErrorCount());
		System.out.println(errors);
		errors.getAllErrors().forEach(e -> System.out.println(context.getMessage(e, Locale.US)));
	}
	@Test
	public void validatorsInjectionJavaTests() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

		ValidatorServices validatorServices = context.getBean(ValidatorServices.class);
		Validator simplePojoValidator = validatorServices.getSpringValidator();
		SimplePojo bean = context.getBean(SimplePojo.class);
		bean.allNames(null);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(bean, "simplePojo");
//		DefaultMessageCodesResolver messageCodesResolver = (DefaultMessageCodesResolver) errors
//				.getMessageCodesResolver();
//		messageCodesResolver.setMessageCodeFormatter(DefaultMessageCodesResolver.Format.POSTFIX_ERROR_CODE);
		// validatorServices.getSpringValidator().validate(bean, errors);
		ValidationUtils.invokeValidator(simplePojoValidator, bean, errors);
		Assert.assertEquals(2, errors.getErrorCount());
		System.out.println(errors);
		errors.getAllErrors().forEach(e -> System.out.println(context.getMessage(e, Locale.US)));
		errors.getAllErrors().forEach(e -> System.out.println(context.getMessage(e, Locale.FRANCE)));
		
	}
}

