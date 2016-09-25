package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CabSearchRequest {
	
	@JsonProperty("gpsStartLat")
	private double gpsStartLat;
	@JsonProperty("gpsStartLon")
	private double gpsStartLon;
	@JsonProperty("gpsEndLat")
	private double gpsEndLat;
	@JsonProperty("gpsEndLon")
	private double gpsEndLon;
	@JsonProperty("gpsCurrentLat")
	private double gpsCurrentLat;
	@JsonProperty("gpsCurrentLon")
	private double gpsCurrentLon;
	@JsonProperty("gender")
	private String gender;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getGpsStartLat() {
		return gpsStartLat;
	}
	public void setGpsStartLat(double gpsStartLat) {
		this.gpsStartLat = gpsStartLat;
	}
	public double getGpsStartLon() {
		return gpsStartLon;
	}
	public void setGpsStartLon(double gpsStartLon) {
		this.gpsStartLon = gpsStartLon;
	}
	public double getGpsEndLat() {
		return gpsEndLat;
	}
	public void setGpsEndLat(double gpsEndLat) {
		this.gpsEndLat = gpsEndLat;
	}
	public double getGpsEndLon() {
		return gpsEndLon;
	}
	public void setGpsEndLon(double gpsEndLon) {
		this.gpsEndLon = gpsEndLon;
	}
	public double getGpsCurrentLat() {
		return gpsCurrentLat;
	}
	public void setGpsCurrentLat(double gpsCurrentLat) {
		this.gpsCurrentLat = gpsCurrentLat;
	}
	public double getGpsCurrentLon() {
		return gpsCurrentLon;
	}
	public void setGpsCurrentLon(double gpsCurrentLon) {
		this.gpsCurrentLon = gpsCurrentLon;
	}

}
