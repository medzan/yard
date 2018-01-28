package com.doc.spring.custom;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServices {

	private Validator javaxValidator;
	private org.springframework.validation.Validator springValidator;
	private ValidatorFactory validatorFactory;

	 public ValidatorServices(Validator javaxValidator,
	 org.springframework.validation.Validator springValidator,
	 ValidatorFactory validatorFactory) {
	 super();
	 this.setJavaxValidator(javaxValidator);
	 this.springValidator = springValidator;
	 this.validatorFactory = validatorFactory;
	 }

	public org.springframework.validation.Validator getSpringValidator() {
		return springValidator;
	}

	public void setSpringValidator(org.springframework.validation.Validator springValidator) {
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


}
