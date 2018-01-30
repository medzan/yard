/**
 * 
 */
package com.doc.spring.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elmehdi.zangui
 *
 */
public class SimplePojo {

	private String name;
	private List<CallPojo> list = new ArrayList<CallPojo>();

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

	public List<CallPojo> getList() {
		return list;
	}

	public void setList(List<CallPojo> list) {
		this.list = list;
	}
}
