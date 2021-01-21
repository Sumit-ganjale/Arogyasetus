package com.ibc.hrrentry.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibc.hrrentry.entity.Answer;
import com.ibc.hrrentry.entity.LoginObject;
import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.entity.SurveyDeatils;
import com.ibc.hrrentry.entity.Survey_Result;
import com.ibc.hrrentry.repository.SurveyServiceRepository;
import com.ibc.hrrentry.service.SurveyService;

@Component
public class SurveyServiceImpl implements SurveyService {

	
	@Autowired
	public SurveyServiceRepository repository;
	
	@Override
	public Survey getSurvey(String username) {
		List<Survey_Result> surveyList=(List<Survey_Result>) repository.getSurveyTemplate(username);
		if(!surveyList.isEmpty()) {
			Survey_Result survey=surveyList.get(0);
			return createSurvayForm(survey.getSurvey());
		}
		return null;
	}

	private Survey createSurvayForm(Survey survey) {
		return survey;
		/*
		 * Survey surveyForm=new Survey(); surveyForm.setName(survey.getName());
		 * surveyForm.setDescription(survey.getDescription());
		 * surveyForm.setQuestion(getQuestions(survey)); return surveyForm;
		 */
	}

	private List<Question> getQuestions(Survey survey) {
		List<Question> questionList=new ArrayList<>();
		List<Question> questions=survey.getQuestion();
		Collections.sort(questions);
		for(Question ques:questions) {
			/*
			 * Question question =new Question(); question.setQuestion(ques.getQuestion());
			 * question.setAnswer(getOptions(ques)); questionList.add(question);
			 */
		}
		// TODO Auto-generated method stub
		return questionList;
	}

	private Set<Answer> getOptions(Question question) {
		Set<Answer> optionList=new HashSet<Answer>();
		Answer answer;
		for(Answer ans:question.getAnswer()) {
			 answer =new Answer();
			 answer.setAnswer(ans.getAnswer());
			 optionList.add(answer);
		}
		
	
		return optionList;
	}

	@Override
	public void saveSurvey(String username,Survey survey) {
		repository.saveSurvey(calculateResult(), username);
		
	}

	private String calculateResult() {
		
		return "Pass";
		//tbd
		
	}

	@Override
	public LoginObject getSurveyResult(String username) {
		List<Survey_Result> surveyList=(List<Survey_Result>) repository.getSurveyTemplate(username);
		if(!surveyList.isEmpty()) {
			Survey_Result surveyResult=surveyList.get(0);
			return customiseSurveyResult(surveyResult);
	}
		return null;
	}

	private LoginObject  customiseSurveyResult(Survey_Result surveyResult) {
		LoginObject object=new LoginObject();
		object.setUsername(surveyResult.getUser_id());
		object.setSurveytaken(checkSurveyTaken(surveyResult.getSurvey_date()));
		SurveyDeatils surveyDetails=new SurveyDeatils();
		surveyDetails.setSurveyResult(surveyResult.getResult());
		surveyDetails.setNextSurveyDate(surveyResult.getSurvey().getNext_survey_date());
		surveyDetails.setSurveyName(surveyResult.getSurvey().getName());
		object.setSurveyDetails(surveyDetails);
		return object;
				
		}
	

	private boolean checkSurveyTaken(Date d1) {
		Date d2=new Date();
	   if (d1.compareTo(d2) < 0) { 
	  
	            // When Date d1 < Date d2 
	           return false; 
	        } 
	  
	        else if (d1.compareTo(d2) == 0) { 
	  
	            return true;
	        }
	return false;
	}
	

	
}
