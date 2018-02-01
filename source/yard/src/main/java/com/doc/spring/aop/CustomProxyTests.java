package com.doc.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doc.spring.jc.Person;

import junit.framework.Assert;

public class CustomProxyTests {

	@Test
	public void createProxyTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		Person person = context.getBean("person",Person.class);
		Assert.assertEquals("Elmehdi",person.YourNamePlz());
	}
}
