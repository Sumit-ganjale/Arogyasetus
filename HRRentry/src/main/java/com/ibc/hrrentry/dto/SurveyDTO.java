package com.ibc.hrrentry.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SurveyDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String description;
	private String status;
	private long frequency;
	private Date next_survey_date; 
	
	
	private List<QuestionDTO> question;
	
	
	 //private Survey_ResultDTO survey_result;
	 
	
	
	
	
	public long getId() {
		return id;
	}
	public Date getNext_survey_date() {
		return next_survey_date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getFrequency() {
		return frequency;
	}
	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}
	
	public List<QuestionDTO> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionDTO> question) {
		this.question = question;
	}
	public void setNext_survey_date(Date next_survey_date) {
		this.next_survey_date = next_survey_date;
	}
	/*
	 * public Survey_ResultDTO getSurvey_result() { return survey_result; } public
	 * void setSurvey_result(Survey_ResultDTO survey_result) { this.survey_result =
	 * survey_result; }
	 */
	
	
	
	
	
}
