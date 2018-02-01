package main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doc.spring.aop.service.CustomService;
import com.doc.spring.config.Application;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		CustomService customService = new CustomService();
		customService.answerTheUltimateUniversQuestion();
	}

}
