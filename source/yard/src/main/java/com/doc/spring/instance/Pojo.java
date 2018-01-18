/**
 * 
 */
package com.doc.spring.instance;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.context.Lifecycle;

/**
 * @author Elmehdi.zangui
 *
 */
public class Pojo extends RequiredAnnotationBeanPostProcessor{
	
	private String name;
	private String another;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnother() {
		return another;
	}
	@Required
	public void setAnother(String another) {
		this.another = another;
	}


}
