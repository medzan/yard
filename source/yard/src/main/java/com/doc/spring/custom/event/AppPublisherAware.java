package com.doc.spring.custom.event;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class AppPublisherAware implements ApplicationEventPublisherAware {
	@Autowired
	private Logger logger;
	
	private ApplicationEventPublisher applicationEventPublisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void checkToPublish(String name) {
		if(!name.equals("")) {
			ApplicationEvent event = new EntityCreatedEvent<AnotherAppEvent>(new AnotherAppEvent());
			applicationEventPublisher.publishEvent(event);
			getLogger().info("publish event "+name);
		}
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
