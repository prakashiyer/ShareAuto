package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateLocationRequest {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("gpsCurrentLat")
	private double gpsCurrentLat;
	@JsonProperty("gpsCurrentLon")
	private double gpsCurrentLon;
	@JsonProperty("type")
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
