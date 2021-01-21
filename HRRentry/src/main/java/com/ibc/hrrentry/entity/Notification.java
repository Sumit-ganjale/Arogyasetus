package com.ibc.hrrentry.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ibc.hrrentry.entity.Survey;

@Entity
@Table(name = "SUY_NOTIFC")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column(name="SUY_NOTIFC_SK")
	private long id;
	@Column(name="NOTIFC_TXT_VAL")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String notification;
	@Column(name="NOTIFC_CHNLTP_ID")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private String notificationType;
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
	@Column(name="NOTIFC_ACTV_IND")
    private String status;
	
	@Column(name="DEL_IND")
	private String delIndicator;
	
	@OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "SVY_SK", nullable = true)
	private Survey survey;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
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

	public String getDelIndicator() {
		return delIndicator;
	}

	public void setDelIndicator(String delIndicator) {
		this.delIndicator = delIndicator;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
	
}
