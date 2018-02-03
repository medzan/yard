package com.doc.spring.custom.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.doc.spring.custom.CustomConstraint;

@Component
@Validated
public class SimplePojo {
	@NotNull
	@Size(min = 1)
	private String name;
	@CustomConstraint
	private String anotherName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnotherName() {
		return anotherName;
	}

	public void setAnotherName(String anotherName) {
		this.anotherName = anotherName;
	}
	
	public String allNames(@NotNull String useless) {
		return null;
	}
}
