package com.doc.spring.listener;

import org.springframework.context.ApplicationEvent;

public class SimpleEvent extends ApplicationEvent{

	public SimpleEvent(Object source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
