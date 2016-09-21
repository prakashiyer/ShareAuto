package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRideRequest {
	
	@JsonProperty("gpsStart")
	private String gpsStart;
	@JsonProperty("driver_id")
	private int driverId;
	@JsonProperty("gpsEnd")
	private String gpsEnd;
	@JsonProperty("user_id")
	private int userId;
	@JsonProperty("cost")
	private double cost;
	
	public String getGpsStart() {
		return gpsStart;
	}
	public void setGpsStart(String gpsStart) {
		this.gpsStart = gpsStart;
	}
	public String getGpsEnd() {
		return gpsEnd;
	}
	public void setGpsEnd(String gpsEnd) {
		this.gpsEnd = gpsEnd;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
}
