package com.doc.spring.custom.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class SimplePojo {
	@NotNull
	@Size(min=1)
	private String name;
}
