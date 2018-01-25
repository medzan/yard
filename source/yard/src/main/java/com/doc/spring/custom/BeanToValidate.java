package com.doc.spring.custom;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BeanToValidate  implements Validator{
	//Nice to have a name at least  
	private String name;
	public boolean supports(Class<?> clazz) {
		return BeanToValidate.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
			ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
