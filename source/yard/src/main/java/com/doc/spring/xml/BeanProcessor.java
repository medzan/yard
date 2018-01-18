/**
 * 
 */
package com.doc.spring.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Elmehdi.zangui
 *
 */
public class BeanProcessor   implements BeanPostProcessor	{
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	return bean;
			
	}
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
