package com.doc.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.custom.CustomConverter;
import com.doc.spring.javaconfig.Application;


public class ConverterTests {

	@Test
	public void CustomConverterTests() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		CustomConverter bean = context.getBean(CustomConverter.class);
		Assert.assertNotNull(bean.getCurrency("USD"));
		Assert.assertEquals("USD", bean.getCurrency("USD").toString());
		List<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));

		String[] result = bean.getListStr(list);
		Assert.assertNotNull(result);
		Assert.assertEquals("1", result[0]);

	}

	@Test
	public void AnnotationDateTest() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		CustomConverter bean = context.getBean(CustomConverter.class);
		bean.setDate(new Date());
		System.out.println(bean.getDate());
	}
}
