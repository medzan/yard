package com.doc.spring.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomConstraintValidator.class)
public @interface CustomConstraint {
	String message() default "Invalid Name dont like it  number";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
