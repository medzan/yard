package com.doc.spring.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.springframework.stereotype.Component;

@Component
public class CustomConstraintValidator implements ConstraintValidator<CustomConstraint, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate("name.isEmpty");
		builder.addPropertyNode("name");
		return value != null && !value.isEmpty();
	}

}
