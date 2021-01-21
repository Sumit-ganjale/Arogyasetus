package com.ibc.hrrentry.entity;

import java.util.Date;

public class SurveyDeatils {
	
	private String surveyName;
	private String surveyResult;
	private Date surveyDate;
	private Date nextSurveyDate;
	private String message;
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public String getSurveyResult() {
		return surveyResult;
	}
	public void setSurveyResult(String surveyResult) {
		this.surveyResult = surveyResult;
	}
	public Date getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(Date surveyDate) {
		this.surveyDate = surveyDate;
	}
	public Date getNextSurveyDate() {
		return nextSurveyDate;
	}
	public void setNextSurveyDate(Date nextSurveyDate) {
		this.nextSurveyDate = nextSurveyDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
 
}
