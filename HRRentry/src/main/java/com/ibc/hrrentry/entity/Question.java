package com.ibc.hrrentry.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
@Table(name = "SUY_QSTN")
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Question implements Comparable< Question >{
	@Id
	@JsonIgnore
	@Column(name="SUY_QSTN_SK")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name="SUY_QSTN_TXT_VAL")
	private String question;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name="SUY_QSTN_TP_CD")
    private String question_type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Column(name="SUY_QSTN_DSC")
    private String description;
	@Column(name="DSPLY_ORDER_NO")
    private int disp_sequence;
	@JsonIgnore
	@Column(name="CRE_TS")
    private Date date_created;
	@Column(name="UPDT_TS")
	@JsonIgnore
	private Date date_updated;
	@Column(name="CRE_USER_ID")
	@JsonIgnore
	private String created_by;
	
	@Column(name="QSTN_ACTV_IND")
	@JsonIgnore
	private String status;
	
	@Column(name="UPDT_USER_ID")
	@JsonIgnore
	private String updated_by;

	@ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "SVY_SK", nullable = false)
	private Survey survey;
	
	@OneToMany(mappedBy = "question", cascade = {CascadeType.MERGE,
            CascadeType.REFRESH})
	private Set<Answer> answer;
	
	@Column(name="DEL_IND")
	private String delIndicator;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Date getDate_updated() {
		return date_updated;
	}
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
	public String getCreated_by() {
		return created_by;
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public Set<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<Answer> answer) {
		addAnswers(answer);
		this.answer = answer;
	}
	@Override
	public int compareTo(Question o) {
		 if(this.getDisp_sequence()<(o.getDisp_sequence())) {
			 return 1;
		 }
		return -1;
	}
	public void addAnswers(Set<Answer> answers)
	{
		for(Answer answer:answers) {
			answer.setQuestion(this);
		}
	}
    
	
}
