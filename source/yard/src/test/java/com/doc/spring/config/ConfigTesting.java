/**
 * 
 */
package com.doc.spring.config;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.SimpleThreadScope;

import com.doc.spring.groovy.GroovyEmbeddedPojo;
import com.doc.spring.groovy.GroovyPojo;
import com.doc.spring.xml.pojo.BasicAwarePojo;
import com.doc.spring.xml.pojo.BasicLoockupInjectionBean;
import com.doc.spring.xml.pojo.ScopeThreadBean;
import com.doc.spring.xml.pojo.XmlDiPojo;
import com.doc.spring.xml.pojo.XmlEmbeddedPojo;
import com.doc.spring.xml.pojo.XmlPojo;
import com.doc.spring.xml.pojo.XmlPropsInheritsPojo;

import junit.framework.Assert;

/**
 * @author Elmehdi.zangui
 *
 */
public class ConfigTesting {

	@Test
	public void xmlConfigTest() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(ConfigConstants.xmlApplication);
		checkXmlPojo(context);
//		context.start();
//		context.refresh();
//		context.stop();
//		context.close();
//		context.shu
	}

	@Test
	public void xmlConfigPropsTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(ConfigConstants.xmlApplication,
				ConfigConstants.xmlBeans);
		checkParentChildXmlPojot(context);
	}

	@Test
	public void groovyAndXmlConfigTest() {
		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions(ConfigConstants.xmlApplication,
				ConfigConstants.xmlBeans);
		new GroovyBeanDefinitionReader(context).loadBeanDefinitions(ConfigConstants.groovyApplication);

		context.refresh();
		checkXmlPojo(context);
		checkGroovyPojo(context);

	}
	@Test
	public void xmlAwarePojoTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(ConfigConstants.xmlApplication,
				ConfigConstants.xmlBeans);
		BasicAwarePojo basicAwarePojo = context.getBean(BasicAwarePojo.class);
		Assert.assertNotNull(basicAwarePojo);
		Assert.assertNotNull(basicAwarePojo.getNewXmlPojoFromContainer());
		System.out.println("new "+basicAwarePojo.getNewXmlPojoFromContainer());
		System.out.println("new "+basicAwarePojo.getNewXmlPojoFromContainer());
		System.out.println(basicAwarePojo.getXmlpojo());
		System.out.println(basicAwarePojo.getXmlpojo());
		
		
	}
	
	@Test
	public void xmlLookupMethodInjectionTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(ConfigConstants.xmlApplication,
				ConfigConstants.xmlBeans);
		BasicLoockupInjectionBean basicLoockupInjectionBean =context.getBean(BasicLoockupInjectionBean.class);
		Assert.assertNotNull(basicLoockupInjectionBean);
		Assert.assertNotNull(basicLoockupInjectionBean.getNewXmlPojo());
		System.out.println(basicLoockupInjectionBean.getNewXmlPojo());
		System.out.println(basicLoockupInjectionBean.getNewXmlPojo());
		
		
	}
	@Test
	public void CustomScopeTest() {
		ConfigurableApplicationContext  context = new ClassPathXmlApplicationContext(ConfigConstants.xmlApplication,
				ConfigConstants.xmlBeans);
		SimpleThreadScope threadScope = new SimpleThreadScope();
		ConfigurableListableBeanFactory  beanFactory = context.getBeanFactory();
		beanFactory.registerScope("thread",threadScope);
		
		ScopeThreadBean bean = context.getBean(ScopeThreadBean.class);
		Assert.assertNotNull(bean);
		
	}
	private void checkGroovyPojo(ApplicationContext context) {
		GroovyPojo groovyPojo = context.getBean(GroovyPojo.class);
		Assert.assertNotNull(groovyPojo);
		Assert.assertNotNull(groovyPojo.getName());
		Assert.assertEquals("Groovy pojo name", groovyPojo.getName());

		GroovyEmbeddedPojo groovyEmbeddedPojo = context.getBean(GroovyEmbeddedPojo.class);
		Assert.assertNotNull(groovyEmbeddedPojo);
		Assert.assertNotNull(groovyEmbeddedPojo.getName());
		Assert.assertEquals("Groovy pojo name", groovyEmbeddedPojo.getGroobyPojo().getName());
		Assert.assertEquals("Groovy pojo embedded name", groovyEmbeddedPojo.getName());
	}

	private void checkXmlPojo(ApplicationContext context) {
//		XmlPojo xmlPojo = context.getBean("xmlname1", XmlPojo.class);
//		Assert.assertNotNull(xmlPojo);
//		Assert.assertNotNull(xmlPojo.getName());
//		Assert.assertEquals("Xml config name", xmlPojo.getName());
//
//		XmlEmbeddedPojo xmlEmbeddedPojo = context.getBean(XmlEmbeddedPojo.class);
//		Assert.assertNotNull(xmlEmbeddedPojo);
//		Assert.assertNotNull(xmlEmbeddedPojo.getXmlPojo());
//		Assert.assertEquals("Xml config name", xmlEmbeddedPojo.getXmlPojo().getName());
//		Assert.assertEquals("xmlEmbedded", xmlEmbeddedPojo.getName());
//
//		XmlDiPojo xmlDiPojo = context.getBean(XmlDiPojo.class);
//		Assert.assertNotNull(xmlDiPojo);
//		Assert.assertNotNull(xmlDiPojo.getName());
//		Assert.assertNotNull(xmlDiPojo.getSecondName());
//		Assert.assertEquals("Name Arg0", xmlDiPojo.getName());
//		Assert.assertEquals("Second Name Arg1", xmlDiPojo.getSecondName());

	}

	private void checkParentChildXmlPojot(ApplicationContext context) {
		XmlPropsInheritsPojo xmlProps = context.getBean(XmlPropsInheritsPojo.class);
		Assert.assertNotNull(xmlProps);
		Assert.assertNotNull(xmlProps.getProps());
		Assert.assertTrue(xmlProps.getProps().containsKey("key1"));
		Assert.assertTrue(xmlProps.getProps().containsKey("key2"));
		Assert.assertTrue(xmlProps.getProps().containsKey("key3ToOverried"));

		Assert.assertEquals("value1child", xmlProps.getProps().getProperty("key1"));
		Assert.assertEquals("value2child", xmlProps.getProps().getProperty("key2"));
		Assert.assertEquals("value3Parent", xmlProps.getProps().getProperty("key3ToOverried"));

	}
}
