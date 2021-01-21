package com.ibc.hrrentry.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Messages {

private String message;

private String description;
@JsonIgnore
private int statusCode;



public int getStatusCode() {
	return statusCode;
}

public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}
}
