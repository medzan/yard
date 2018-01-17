/**
 * 
 */
package com.doc.spring.xml.pojo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Elmehdi.zangui
 *
 */
public class BasicAwarePojo implements ApplicationContextAware {

	private ApplicationContext context;
	private XmlPojo xmlpojo;
	
	public XmlPojo getNewXmlPojoFromContainer() {
		return context.getBean(XmlPojo.class);
	}
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context=context;
	}


	public XmlPojo getXmlpojo() {
		return xmlpojo;
	}


	public void setXmlpojo(XmlPojo xmlpojo) {
		this.xmlpojo = xmlpojo;
	}

}
