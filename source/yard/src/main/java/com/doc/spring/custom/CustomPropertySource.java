/**
 * 
 */
package com.doc.spring.custom;

import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 * @param <T>
 *
 */
public class CustomPropertySource<T> extends PropertySource<T>{

	public CustomPropertySource(String name) {
		super(name);
	}

	@Override
	public Object getProperty(String key) {
		if(key.equals("custom")) {
			return true;
		}
		return null;
	}

}
