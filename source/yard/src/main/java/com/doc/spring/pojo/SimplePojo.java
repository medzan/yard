/**
 * 
 */
package com.doc.spring.pojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class SimplePojo {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public  String call() {
		return "Not arg";
	}

	public String call(String ag0) {
		return "Only one arg " + ag0;
	}
}
