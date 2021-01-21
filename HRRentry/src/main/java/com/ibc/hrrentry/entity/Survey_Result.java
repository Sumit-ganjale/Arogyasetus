package com.ibc.hrrentry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
@Table(name = "SUY_RSL")
public class Survey_Result implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SVY_RSL_SK")
	private int id;
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="SUY_TS")
    private Date survey_date;
	@Column(name="SUV_RSL_PASS_IND")
	private String result;
	
	@Column(name="CRE_TS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private Date date_created;
	@Column(name="UPDT_TS")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date date_updated;
	@Column(name="CRE_USER_ID")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String created_by;
	@Column(name="UPDT_USER_ID")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String updated_by;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SVY_SK", nullable = false)
	private Survey survey;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public Date getSurvey_date() {
		return survey_date;
	}
	public void setSurvey_date(Date survey_date) {
		this.survey_date = survey_date;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public String getResult() {
		return result;
	}
	public void setresult(String result) {
		this.result = result;
	}
	
    
	
}
