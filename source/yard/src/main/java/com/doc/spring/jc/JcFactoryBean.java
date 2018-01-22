/**
 * 
 */
package com.doc.spring.jc;

import javax.inject.Inject;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Elmehdi.zangui
 *
 */
@Component
public class JcFactoryBean {
	
	@Inject
	private Provider<JcPojo> jcpojo;
	
	@Autowired
	private BeanFactory jcpojobean;
	
	@Inject
	private JcPojo jcPro;
	
	private static Logger logger;
	

	@SuppressWarnings("static-access")
	public JcFactoryBean(Logger logger) {
		this.logger=logger;
	}
	public void logSomething(String something) {
		logger.info(something);
	}
	public Provider<JcPojo> getJcpojo() {
		return jcpojo;
	}
	public void setJcpojo(Provider<JcPojo> jcpojo) {
		this.jcpojo = jcpojo;
	}
	public JcPojo getJcPro() {
		return jcPro;
	}
	public void setJcPro(JcPojo jcPro) {
		this.jcPro = jcPro;
	}
	public BeanFactory getJcpojobean() {
		return jcpojobean;
	}
	public void setJcpojobean(BeanFactory jcpojobean) {
		this.jcpojobean = jcpojobean;
	}
}
