package com.ibc.hrrentry.utils;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibc.hrrentry.entity.Answer;
import com.ibc.hrrentry.entity.Notification;
import com.ibc.hrrentry.entity.Question;
import com.ibc.hrrentry.entity.Survey;
import com.ibc.hrrentry.repository.QuestionServiceConfigRepository;
import com.ibc.hrrentry.repository.SurveyServiceConfigRepository;
@Component
public class SurveyUtils {
	
	@Autowired
	SurveyServiceConfigRepository surveyServiceConfigRepository;
	
	@Autowired
	QuestionServiceConfigRepository questionServiceConfigRepository;

	public static Object addAuditDetails(Object object) {
		Date date = new Date();
		if(object instanceof Notification) {
		((Notification) object).setDate_created(date);
		((Notification)object).setCreated_by("");
		}else 
			if(object instanceof Survey) {
				((Survey) object).setDate_created(date);
				((Survey)object).setCreated_by("");
				
		}else 
			if(object instanceof Question) {
				((Question) object).setDate_created(date);
				((Question)object).setCreated_by("");
		}
		else 
			if(object instanceof Answer) {
					((Answer) object).setDate_created(date);
					((Answer)object).setCreated_by("");
			}
		return object;
		}
	public static Object updateAuditDetails(Object object) {
		Date date = new Date();
		if(object instanceof Notification) {
		((Notification) object).setDate_updated(date);
		((Notification)object).setUpdated_by("");
		}else 
			if(object instanceof Survey) {
				((Survey) object).setDate_updated(date);
				((Survey)object).setUpdated_by("");
				
		}else 
			if(object instanceof Question) {
				((Question) object).setDate_updated(date);
				((Question)object).setUpdated_by("");
		}
		else 
			if(object instanceof Answer) {
					((Answer) object).setDate_updated(date);
					((Answer)object).setUpdated_by("");
			}
		return object;
		}
	public Survey findSurveyById(long survey_id) {
		// TODO Auto-generated method stub
		Optional<Survey> surveyList=surveyServiceConfigRepository.findById(survey_id);
		return surveyList.map(Stream::of).orElseGet(Stream::empty).findFirst().orElse(null);
	}
	public Question findQuestionId(long id) {
		// TODO Auto-generated method stub
		Optional<Question> surveyList=questionServiceConfigRepository.findById(id);
		return surveyList.map(Stream::of).orElseGet(Stream::empty).findFirst().orElse(null);
	}
}