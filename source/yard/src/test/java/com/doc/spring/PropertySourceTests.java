/**
 * 
 */
package com.doc.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import com.doc.spring.custom.CustomPropertySource;
import com.doc.spring.javaconfig.Application;

import junit.framework.Assert;

/**
 * @author Elmehdi.zangui
 *
 */
public class PropertySourceTests {

	@Test
	public void CustomPropertySourceTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Application.class);
		MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
		propertySources.addFirst(new CustomPropertySource<Object>("name"));
		context.refresh();
		Assert.assertTrue(context.getEnvironment().containsProperty("custom"));
		Assert.assertFalse(context.getEnvironment().containsProperty("XXXX"));
	}

	@Test
	public void PropertiesFileTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		Assert.assertTrue(context.getEnvironment().containsProperty("default"));
		Assert.assertFalse(context.getEnvironment().containsProperty("XXXX"));
		
	}
}
