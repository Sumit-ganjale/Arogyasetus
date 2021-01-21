package com.ibc.hrrentry.dto;

import java.util.Date;

public class Survey_ResultDTO  {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user_id;
    private String description;
    private Date survey_date;
	private String result;
	
	private SurveyDTO survey;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getSurvey_date() {
		return survey_date;
	}
	public void setSurvey_date(Date survey_date) {
		this.survey_date = survey_date;
	}

	public String getResult() {
		return result;
	}
	public void setresult(String result) {
		this.result = result;
	}
	public SurveyDTO getSurvey() {
		return survey;
	}
	public void setSurvey(SurveyDTO survey) {
		this.survey = survey;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
    
	
}
