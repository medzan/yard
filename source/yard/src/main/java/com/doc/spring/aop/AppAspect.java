package com.doc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.doc.spring.aop.target.MostUseLessPojo;

//@Aspect
//@Component
//@Order(1)
public class AppAspect {
	public AppAspect() {
		System.out.println("i'am here");
	}

	@Pointcut("execution (* whoIam(..))")
	public void lostedPointCut( ) {
	}

	@Before("execution (* whoIam(..)) && args(useless,..)")
	public void callPiontcut(MostUseLessPojo useless) {
		System.out.println("Point cut called "+useless.getName() );
	}

	@AfterReturning(pointcut = "lostedPointCut()", returning = "name")
	public void afterReturning(JoinPoint jp,String name) {
		System.out.println("afterReturning " + name);
	}
	@AfterThrowing(pointcut="lostedPointCut()" , throwing="ex")
	public void afterWithException(Exception ex) {
		System.out.println("Exception occur "+ex.getMessage());
	}
	
	@Around("lostedPointCut()")
	public String around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Around Begin");
		String proceed = (String) jp.proceed();
		System.out.println("Around end "+proceed);
		 proceed = (String) jp.proceed();
		System.out.println("Around end "+proceed);
		return proceed;

	}
}
