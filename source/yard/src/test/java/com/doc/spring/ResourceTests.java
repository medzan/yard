package com.doc.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;

import com.doc.spring.custom.CustomResourceLoader;
import com.doc.spring.javaconfig.Application;

public class ResourceTests {

	@Test
	public void loadingDifferentFiles() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		// Load with classpath
		ClassPathResource resource = (ClassPathResource) context.getResource("classpath*:DumpFile.txt");
		Assert.assertNotNull(resource);
		FileUrlResource resource2 = (FileUrlResource) context
				.getResource("file:D:\\Mes Documents\\Work\\Projects\\YARD\\source\\yard\\src\\main\\resources");
		Assert.assertNotNull(resource2);

		CustomResourceLoader bean = context.getBean(CustomResourceLoader.class);
		resource = (ClassPathResource) bean.getResourceLoader().getResource("classpath:DumpFile.txt");
		Assert.assertNotNull(resource);
		resource = bean.getResource();
		Assert.assertNotNull(resource);

	}
	//Required jar with application.xml file
	@Test
	public void loadingMultipleClassWildCard() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:application.xml");
		CustomResourceLoader loader = context.getBean(CustomResourceLoader.class);
		Assert.assertNotNull(loader);
	}
}
