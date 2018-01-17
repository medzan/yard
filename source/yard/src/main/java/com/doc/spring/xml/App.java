package com.doc.spring.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.context.request.RequestContextListener;

import com.doc.spring.config.ConfigConstants;
import com.doc.spring.xml.pojo.XmlEmbeddedPojo;
import com.doc.spring.xml.pojo.XmlPojo;

public class App {
	static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		RequestContextListener l = new RequestContextListener();
		
		
		System.exit(1);

	}
}
