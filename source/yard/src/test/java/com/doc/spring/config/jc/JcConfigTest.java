/**
 * 
 */
package com.doc.spring.config.jc;

import javax.inject.Provider;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.javaconfig.Application;
import com.doc.spring.jc.JcFactoryBean;
import com.doc.spring.jc.JcPojo;

import junit.framework.Assert;

/**
 * @author Elmehdi.zangui
 *
 */
public class JcConfigTest {

	@Test
	public void BasicScanTest() {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		JcPojo bean = context.getBean(JcPojo.class);
		Assert.assertNotNull(bean);
	}
	
	@Test
	public void injectionPointTest() {
		ApplicationContext context= new AnnotationConfigApplicationContext(Application.class);
		JcFactoryBean factory = context.getBean(JcFactoryBean.class);
		Assert.assertNotNull(factory);
		Provider<JcPojo> provider = factory.getJcpojo();
		System.out.println(provider.get().hashCode());
		System.out.println(provider.get().hashCode());
		System.out.println(provider.get().hashCode());
		System.out.println("\nfields\n ");
		
		System.out.println(factory.getJcPro().hashCode());
		System.out.println(factory.getJcPro().hashCode());
		
		System.out.println(factory.getJcpojobean().getBean(JcPojo.class));
		System.out.println(factory.getJcpojobean().getBean(JcPojo.class));
		
		factory.logSomething("Something ");
		

	}
}
