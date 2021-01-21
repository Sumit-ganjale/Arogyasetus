package com.ibc.hrrentry.dto;

public class AnswerDTO implements Comparable<AnswerDTO>{
	
	private long id;
	private String answer;
	private long question_id;
    private String description;
	
   
    private int disp_sequence;
	private QuestionDTO question;
	
	
	
	public int getDisp_sequence() {
		return disp_sequence;
	}
	public void setDisp_sequence(int disp_sequence) {
		this.disp_sequence = disp_sequence;
	}
	
	public long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(long question_id) {
		this.question_id = question_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
	@Override
	public int compareTo(AnswerDTO o) {
		 if(this.getDisp_sequence()<(o.getDisp_sequence())) {
			 return 1;
		 }
		 if(this.getDisp_sequence()==o.getDisp_sequence()) {
			 return -1;
		 }
	return 1;
	}
	
	
}
