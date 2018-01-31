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
	private int id;
	private List<CallPojo> list = new ArrayList<CallPojo>();

	public String getName() {
		return name;
	}

	public SimplePojo(String name) {
		super();
		this.name = name;
	}

	public SimplePojo() {
		super();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
