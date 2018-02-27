package com.doc.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SimpleAspect {

	@Around("execution(* com.doc.spring.dao.SimpleDao.*(..))")
	public void wrapAll(ProceedingJoinPoint jp) {
		System.out.println("aspect begin");

		try {
			jp.proceed();
			
		}catch (Exception e ) {
			System.out.println("Exeception occur "+e);
		} catch (Throwable e) {
			System.out.println("Throwable occur "+e);
		}
		System.out.println("aspect end");

	}
}
