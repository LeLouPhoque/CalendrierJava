package com.example.demo;

import java.util.Date;

public class ICal {

private Date dtStamp;
private int dtStart;
private String summary;
private String description;
private String location;
private int dtend;

public ICal(Date dtStamp, int dtStart, String summary, String description, String location, int dtend) {
	super();
	this.dtStamp = dtStamp;
	this.dtStart = dtStart;
	this.summary = summary;
	this.description = description;
	this.location = location;
	this.dtend = dtend;
}

public void setDtStart(int dtStart) {
	this.dtStart = dtStart;
}

public void setDtend(int dtend) {
	this.dtend = dtend;
}

public int getDtend() {
	return this.dtend;
}

public int getDtStart() {
	return this.dtStart;
}

public Date getDtStamp() {
	return dtStamp;
}

public void setDtStamp(Date dtStamp) {
	this.dtStamp = dtStamp;
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
}

