package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CabDetails {
	
	@JsonProperty("driverId")
	private int driverId;
	@JsonProperty("driverName")
	private String driverName;
	@JsonProperty("cabId")
	private String cabId;
	@JsonProperty("cabMake")
	private String cabMake;
	@JsonProperty("passengers")
	private int passengers;
	@JsonProperty("cost")
	private double cost;
	@JsonProperty("indicator")
	private String indicator;
	@JsonProperty("gpsCurrentLat")
	private double gpsCurrentLat;
	@JsonProperty("gpsCurrentLon")
	private double gpsCurrentLon;
	
	public CabDetails(int driverId, String driverName, String cabId,
			String cabMake, int passengers, double cost,
			String indicator, double gpsCurrentLat, double gpsCurrentLon) {
		this.driverId = driverId;
		this.driverName = driverName;
		this.cabId = cabId;
		this.cabMake = cabMake;
		this.passengers = passengers;
		this.cost = cost;
		this.indicator = indicator;
		this.gpsCurrentLat = gpsCurrentLat;
		this.gpsCurrentLon = gpsCurrentLon;
	}
	
	public int getDriverId() {
		return driverId;
	}
	
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public String getCabId() {
		return cabId;
	}
	
	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCabMake() {
		return cabMake;
	}

	public void setCabMake(String cabMake) {
		this.cabMake = cabMake;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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
