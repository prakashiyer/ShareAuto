package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerRequest {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("mobile_number")
	private int mobileNumber;
	@JsonProperty("email_id")
	private String emailId;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("city")
	private String city;
	@JsonProperty("gpsCurrent")
	private String gpsCurrent;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGpsCurrent() {
		return gpsCurrent;
	}
	public void setGpsCurrent(String gpsCurrent) {
		this.gpsCurrent = gpsCurrent;
	}
	

}
