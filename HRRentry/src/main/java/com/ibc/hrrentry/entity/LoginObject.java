package com.ibc.hrrentry.entity;

public class LoginObject {
	
	private String token;
	private String username;
	private String role;
	private boolean surveytaken;
	private SurveyDeatils surveyDetails;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isSurveytaken() {
		return surveytaken;
	}
	public void setSurveytaken(boolean surveytaken) {
		this.surveytaken = surveytaken;
	}
	public SurveyDeatils getSurveyDetails() {
		return surveyDetails;
	}
	public void setSurveyDetails(SurveyDeatils surveyDetails) {
		this.surveyDetails = surveyDetails;
	}
	

}
