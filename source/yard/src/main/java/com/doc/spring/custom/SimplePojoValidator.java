package com.doc.spring.custom;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.doc.spring.custom.pojo.SimplePojo;

@Component
public class SimplePojoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SimplePojo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "empty",
              "Stuff  cannot be empty");
	}

}
