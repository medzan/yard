package com.doc.spring.aop.advisor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CustomAdvisor implements  MethodBeforeAdvice  {
	private String someProperty;
	public void before(Method arg0, Object[] arg1, Object target) throws Throwable {
		System.out.println("executed befor => "+arg0+" "+arg1+"  "+target );
	}
	public String getSomeProperty() {
		return someProperty;
	}
	public void setSomeProperty(String someProperty) {
		this.someProperty = someProperty;
	}


}
