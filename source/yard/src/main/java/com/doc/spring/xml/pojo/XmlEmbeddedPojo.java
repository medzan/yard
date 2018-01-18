package com.doc.spring.xml.pojo;

import org.springframework.beans.factory.annotation.Required;

import com.doc.spring.instance.Pojo;

public class XmlEmbeddedPojo extends Pojo {
	
	private XmlPojo xmlPojo;

	public XmlPojo getXmlPojo() {
		return xmlPojo;
	}
	
	@Required
	public void setXmlPojo(XmlPojo xmlPojo) {
		this.xmlPojo = xmlPojo;
	}

}
