package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CabSearchRequest {
	
	@JsonProperty("gpsStart")
	private String gpsStart;
	@JsonProperty("startLocation")
	private int startLocation;
	@JsonProperty("gpsEnd")
	private String gpsEnd;
	@JsonProperty("endLocation")
	private String endLocation;
	@JsonProperty("gender")
	private String gender;
	public String getGpsStart() {
		return gpsStart;
	}
	public void setGpsStart(String gpsStart) {
		this.gpsStart = gpsStart;
	}
	public int getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(int startLocation) {
		this.startLocation = startLocation;
	}
	public String getGpsEnd() {
		return gpsEnd;
	}
	public void setGpsEnd(String gpsEnd) {
		this.gpsEnd = gpsEnd;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
