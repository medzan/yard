/**
 * 
 */
package com.doc.spring.factory;

import com.doc.spring.xml.pojo.XmlPojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class PojoFactory {

	public  XmlPojo createPojo() {
		XmlPojo xmlPojo = new XmlPojo();
		xmlPojo.setName("Xml config name");
		return xmlPojo;

	}
}
