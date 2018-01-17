/**
 * 
 */
package com.doc.spring.xml.pojo;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;

/**
 * @author Elmehdi.zangui
 *
 */
public abstract class BasicLoockupInjectionBean {
	private XmlPojo xmlpojo;

	public abstract XmlPojo getNewXmlPojo();
	
	public XmlPojo getXmlpojo() {
		ServiceLocatorFactoryBean  s;
		return xmlpojo;
	}

	public void setXmlpojo(XmlPojo xmlpojo) {
		this.xmlpojo = xmlpojo;
	}
	
}
