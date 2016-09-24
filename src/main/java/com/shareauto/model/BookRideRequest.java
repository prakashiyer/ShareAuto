package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRideRequest {
	
	@JsonProperty("gpsStartLat")
	private double gpsStartLat;
	@JsonProperty("gpsStartLon")
	private double gpsStartLon;
	@JsonProperty("driverId")
	private int driverId;
	@JsonProperty("gpsEndLat")
	private double gpsEndLat;
	@JsonProperty("gpsEndLon")
	private double gpsEndLon;
	@JsonProperty("userId")
	private String userId;
	@JsonProperty("cost")
	private double cost;
	
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
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
	
	
}
