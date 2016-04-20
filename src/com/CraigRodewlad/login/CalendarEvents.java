package com.CraigRodewlad.login;

public class CalendarEvents {
	private String eventName;
	private String eventDate;
	private String eventDescription;
	
	public CalendarEvents(String eventName, String startDate, String eventDescription) {
		super();
		this.eventName = eventName;
		this.eventDate = startDate;
		this.eventDescription = eventDescription;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventDate() {
		return eventDate;
	}
	
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
}
