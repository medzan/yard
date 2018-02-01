package com.doc.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.doc.spring.aop.introduction.IInto;
import com.doc.spring.aop.introduction.IntroService;

//@Component
//@Aspect
public class AppIntroduction {

	@DeclareParents(value = "com.doc.spring.aop.service.*", defaultImpl = IntroService.class)
	public static IInto intro;

	@Before("execution( * *(..)) ")
	public String beforeService() {
		System.out.println(" ==< "  +intro.isImplemented());
		return intro.isImplemented();
	}
}
