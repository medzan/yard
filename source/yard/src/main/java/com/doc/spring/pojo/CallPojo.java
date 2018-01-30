package com.doc.spring.pojo;

import java.util.ArrayList;
import java.util.List;

public class CallPojo {
	private List<SimplePojo> list = new ArrayList<SimplePojo>(); 
	public String call() {
		return "I'am working";
	}
	public List<SimplePojo> getList() {
		return list;
	}
	public void setList(List<SimplePojo> list) {
		this.list = list;
	}
}
