package com.doc.spring.custom.event;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AppListener {
	@Autowired
	private Logger logger;

	@EventListener
	@Order(1)
	public AnotherAppEvent onReceivedEvent(EntityCreatedEvent<AppEvent> event) {
		logger.info("Event Received => 1 " + event);
//		AnotherAppEvent anotherAppEvent = new AnotherAppEvent(this, (String) event.getSource());
		return null;
	}

	@EventListener
	@Order(2)

	public void onReceivedEvent2(AppEvent event) {
		logger.info("Event Received => 2  " + event);
//		AnotherAppEvent anotherAppEvent = new AnotherAppEvent(this, event.getEventName());
//		return anotherAppEvent;
	}

	@EventListener
	@Async
	public void onReceivedAnotherEvent(AnotherAppEvent event) {
		logger.info("Another Event " + event);
	}

}
