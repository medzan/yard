package com.doc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.custom.event.AppPublisherAware;
import com.doc.spring.javaconfig.Application;

public class EventPublisherTest {

	@Test
	public void customClassesEventTest()
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		AppPublisherAware bean = context.getBean(AppPublisherAware.class);
		bean.checkToPublish("Bean");
		//check logs
	}
	
}	