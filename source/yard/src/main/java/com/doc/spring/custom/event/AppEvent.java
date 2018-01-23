package com.doc.spring.custom.event;

public class AppEvent {

	private String eventName;

	public AppEvent(String eventName) {
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "AppEvent [eventName=" + eventName + "]";
	}

}
