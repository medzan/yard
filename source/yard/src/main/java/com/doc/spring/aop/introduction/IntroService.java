package com.doc.spring.aop.introduction;


public class IntroService implements IInto{

	public String isImplemented() {
		return this.getClass().getName();
	}

}
