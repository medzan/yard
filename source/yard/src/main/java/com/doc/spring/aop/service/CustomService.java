package com.doc.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class CustomService {

	public void answerTheUltimateUniversQuestion() throws InterruptedException {
		System.out.println("executed");
		Thread.sleep(2000);
	}
}
