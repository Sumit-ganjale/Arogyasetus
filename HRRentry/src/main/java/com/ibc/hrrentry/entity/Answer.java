package com.ibc.hrrentry.entity;

import java.util.Date;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
@Table(name = "SUY_ANSW")
public class Answer implements Comparable<Answer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name="SUY_ANSW_SK")
	private long id;
	@Column(name="SUY_ANSW_TXT_VAL")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String answer;
	@Column(name="description")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
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
	@Column(name="QSTN_ORD_NO")
    private int disp_sequence;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUY_QSTN_SK",referencedColumnName = "SUY_QSTN_SK")
	private Question question;
	
	
	@Column(name="DEL_IND")
	private String delIndicator;
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int compareTo(Answer o) {
		 if(this.getDisp_sequence()<(o.getDisp_sequence())) {
			 return 0;
		 }
		return -1;
	}
	
}
