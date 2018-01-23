package com.doc.spring;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.javaconfig.Application;

public class ResourceMessageTest {

	@Test
	public void simpleResourceReaderTest() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		String message = context.getMessage("hello", new Object[] {"mehdi"}, null);
		Assert.assertNotNull(message);
		String message2 = context.getMessage("hello", new Object[] {"mehdi"}, Locale.FRANCE);
		Assert.assertNotNull(message2);
		String message3 = context.getMessage("argument.required", null, Locale.CHINA);
		System.out.println(message3);
		Assert.assertNotNull(message3);
		
		
		
	}
}
