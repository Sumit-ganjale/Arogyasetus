package com.ibc.hrrentry.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibc.hrrentry.dto.NotificationDTO;

@Entity
@Table(name = "SUY")
public class Survey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@JsonIgnore
	@Column(name = "SVY_SK")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="SVY_NM")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	@Column(name="SVY_TXT_VAL")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
	@Column(name="STS_ACTV_IND") 
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String status;
	@Column(name="SVY_FREQ_NO ")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private long frequency;
	
	@Column(name="NXT_SVY_TS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date next_survey_date;
	@JsonIgnore
	@Column(name="CRE_TS") 
	private Date date_created;
	@JsonIgnore
	@Column(name="UPDT_TS") 
	private Date date_updated;
	@JsonIgnore
	@Column(name="CRE_USER_ID") 
	private String created_by;
	@JsonIgnore
	@Column(name="UPDT_USER_ID")
	private String updated_by;
	
	@Column(name="DEL_IND")
	private String delIndicator;
	
	
	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
	private List<Question> question;
	
	
	 @OneToOne(mappedBy = "survey",cascade = CascadeType.ALL) 
	 private Survey_Result survey_result;
	 
	 @OneToOne(mappedBy = "survey",cascade = CascadeType.ALL) 
	 private Notification notification;
	 
	public void setId(int id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
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
	public Date getNext_survey_date() {
		return next_survey_date;
	}
	public void setNext_survey_date(Date next_survey_date) {
		this.next_survey_date = next_survey_date;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
	
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		addQuestions(question);
		this.question=question;
	}
	public Survey_Result getSurvey_result() {
		return survey_result;
	}
	public void setSurvey_result(Survey_Result survey_result) {
		this.survey_result = survey_result;
	}
	
	
	

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public void addQuestions(List<Question> questions)
	{
		for(Question question:questions) {
			question.setSurvey(this);
		}
	}	
	
}
