/**
 * 
 */
package com.doc.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 *
 */
//@Component
public class SimpleBean {
	
	@Value("${prop:prop}")
	private String prop;
	
	private String name;
	private String profile;

	public SimpleBean() {
	}

	public SimpleBean(String profile) {
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

}
