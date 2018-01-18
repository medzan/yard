/**
 * 
 */
package com.doc.spring.xml.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

import com.doc.spring.instance.Pojo;

/**
 * @author Elmehdi.zangui
 *
 */
public class XmlPojo extends Pojo implements SmartLifecycle , BeanNameAware ,BeanFactoryAware {
	
	public void start() {
		System.out.println("Start " + this.getClass());
	}

	public void stop() {
		System.out.println("Stop " + this.getClass());		
	}

	public boolean isRunning() {
		System.out.println("Running " + this.getClass());		

		return true;
	}
	
	public void init() {
		System.out.println("init " + this.getClass());
	}
	
	public void destory() {
		System.out.println("destory " + this.getClass());
	}

	public int getPhase() {
		return 0;
	}

	public boolean isAutoStartup() {
		return false;
	}

	public void stop(Runnable callback) {
		System.out.println();
	}

	public void setBeanName(String name) {
		System.out.println("Bean Name "+name);
	}

	public void setBeanFactory(BeanFactory factory) throws BeansException {
		System.out.println("Factory "+factory);
	}
}
