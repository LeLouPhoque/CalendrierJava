package com.example.demo;

import java.util.Date;

public class ICal {

private Date dtStamp;
private String dtStart;
private String summary;
private String description;
private String location;
private String dtend;

public ICal(Date dtStamp, String dtStart, String summary, String description, String location, String dtend) {
	super();
	this.dtStamp = dtStamp;
	this.dtStart = dtStart;
	this.summary = summary;
	this.description = description;
	this.location = location;
	this.dtend = dtend;
}

public Date getDtStamp() {
	return dtStamp;
}

public void setDtStamp(Date dtStamp) {
	this.dtStamp = dtStamp;
}

public String getDtStart() {
	return dtStart;
}

public void setDtStart(String dtStart) {
	this.dtStart = dtStart;
}

public String getSummary() {
	return summary;
}

public void setSummary(String summary) {
	this.summary = summary;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getDtend() {
	return dtend;
}

public void setDtend(String dtend) {
	this.dtend = dtend;
}
}

