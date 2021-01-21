package com.ibc.hrrentry.dto;

import java.util.Set;

import com.ibc.hrrentry.entity.Survey;

public class QuestionDTO implements Comparable< QuestionDTO >{
	
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long survey_id;
	private String question;
	
    private String question_type;
	
    private String description;
	
    private int disp_sequence;
	
    private Survey survey;	
	
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	private Set<AnswerDTO> answer;
	
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDisp_sequence() {
		return disp_sequence;
	}
	public void setDisp_sequence(int disp_sequence) {
		this.disp_sequence = disp_sequence;
	}
	
	public Set<AnswerDTO> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<AnswerDTO> answer) {
		this.answer = answer;
	}
	public long getSurvey_id() {
		return survey_id;
	}
	public void setSurvey_id(long survey_id) {
		this.survey_id = survey_id;
	}
	@Override
	public int compareTo(QuestionDTO o) {
		 if(this.getDisp_sequence()<(o.getDisp_sequence())) {
			 return -1;
		 }else
			 if(this.getDisp_sequence()==o.getDisp_sequence()) {
				 return -1;
			 }
		return 1;
	}
    
    
	
}
