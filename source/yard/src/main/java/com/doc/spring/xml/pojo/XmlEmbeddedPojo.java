package com.doc.spring.xml.pojo;

import com.doc.spring.instance.Pojo;

public class XmlEmbeddedPojo extends Pojo{

	private XmlPojo xmlPojo;

	public XmlPojo getXmlPojo() {
		return xmlPojo;
	}

	public void setXmlPojo(XmlPojo xmlPojo) {
		this.xmlPojo = xmlPojo;
	}

}
