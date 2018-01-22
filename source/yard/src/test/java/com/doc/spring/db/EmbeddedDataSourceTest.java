/**
 * 
 */
package com.doc.spring.db;

import java.lang.annotation.Annotation;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.config.ConfigConstants;
import com.doc.spring.javaconfig.Application;
import com.doc.spring.javaconfig.db.HsqlDbConfig;

import junit.framework.Assert;

/**
 * @author Elmehdi.zangui
 *
 */
public class EmbeddedDataSourceTest {

	@Test
	public void HsqlDbTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(ConfigConstants.HSQL_PROFILE);
		context.register(Application.class);
		context.refresh();
		DataSource ds = context.getBean(DataSource.class);
		Assert.assertNotNull(ds);
	}
	
	@Test
	public void H2DbTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(ConfigConstants.H2_PROFILE);
		context.register(Application.class);
		context.refresh();
		DataSource ds = context.getBean(DataSource.class);
		Assert.assertNotNull(ds);
	}
	
	@Test
	public void derbyDbTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles(ConfigConstants.DERBY_PROFILE);
		context.register(Application.class);
		context.refresh();
		DataSource ds = context.getBean(DataSource.class);
		Assert.assertNotNull(ds);
	}

}
