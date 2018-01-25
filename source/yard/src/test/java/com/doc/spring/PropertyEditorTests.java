package com.doc.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doc.spring.custom.DependsOnExoticType;

import junit.framework.Assert;

@SuppressWarnings("resource")
public class PropertyEditorTests {

	@Test
	public void customEditorConfigureXml() {
		ApplicationContext context  = new ClassPathXmlApplicationContext("application.xml");	
		DependsOnExoticType bean = context.getBean(DependsOnExoticType.class);
		Assert.assertNotNull(bean);
		Assert.assertNotNull(bean.getType().getName());
		Assert.assertEquals(bean.getType().getName(), "ThisMeThe_ExoticType");
	}
}
