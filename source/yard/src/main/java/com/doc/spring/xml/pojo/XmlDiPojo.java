/**
 * 
 */
package com.doc.spring.xml.pojo;

import com.doc.spring.instance.Pojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class XmlDiPojo extends Pojo {

	private String secondName;

	public XmlDiPojo(String name, String secondName) {
		super.setName(name);
		this.secondName=secondName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}
