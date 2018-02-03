package com.doc.spring.custom;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Service
public class ValidatorServices {

	private Validator javaxValidator;
	private ValidatorFactory validatorFactory;

	private org.springframework.validation.Validator springValidator;
	@Autowired
	private SimplePojoValidator simplePojoValidator;

	public ValidatorServices(Validator javaxValidator, org.springframework.validation.Validator springValidator,
			ValidatorFactory validatorFactory) {
		super();
		this.setJavaxValidator(javaxValidator);
		this.springValidator = springValidator;
		this.validatorFactory = validatorFactory;
	}

	public org.springframework.validation.Validator getSpringValidator() {
		return springValidator;
	}

	public void setSpringValidator(LocalValidatorFactoryBean springValidator) {
		this.springValidator = springValidator;
	}

	public ValidatorFactory getValidatorFactory() {
		return validatorFactory;
	}

	public void setValidatorFactory(ValidatorFactory validatorFactory) {
		this.validatorFactory = validatorFactory;
	}

	public Validator getJavaxValidator() {
		return javaxValidator;
	}

	public void setJavaxValidator(Validator javaxValidator) {
		this.javaxValidator = javaxValidator;
	}

	public SimplePojoValidator getSimplePojoValidator() {
		return simplePojoValidator;
	}

	public void setSimplePojoValidator(SimplePojoValidator simplePojoValidator) {
		this.simplePojoValidator = simplePojoValidator;
	}

}
