package com.ibc.hrrentry.dto;

import com.ibc.hrrentry.entity.Survey;


public class NotificationDTO {
	
	private long id;

	private long survey_id;
	


	private String notification;


    private String notificationType;

    private String status;
	
	private String delIndicator;
	

	private Survey survey;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNotification() {
		return notification;
	}


	public void setNotification(String notification) {
		this.notification = notification;
	}


	public String getNotificationType() {
		return notificationType;
	}


	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public long getSurvey_id() {
		return survey_id;
	}


	public void setSurvey_id(long survey_id) {
		this.survey_id = survey_id;
	}
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDelIndicator() {
		return delIndicator;
	}


	public void setDelIndicator(String delIndicator) {
		this.delIndicator = delIndicator;
	}


	
	
}
