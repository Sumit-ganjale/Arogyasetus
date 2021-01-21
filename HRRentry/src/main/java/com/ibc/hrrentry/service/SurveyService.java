package com.ibc.hrrentry.service;

import com.ibc.hrrentry.entity.LoginObject;
import com.ibc.hrrentry.entity.Survey;

public interface SurveyService {
	
	public Survey getSurvey(String username);
	public void saveSurvey(String username,Survey survey);
	public LoginObject getSurveyResult(String username);
	

}
