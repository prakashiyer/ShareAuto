package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CabDetails {
	
	@JsonProperty("driver_id")
	private int driverId;
	@JsonProperty("driver_name")
	private String driverName;
	@JsonProperty("cab_id")
	private String cabId;
	@JsonProperty("cab_make")
	private String cabMake;
	@JsonProperty("passengers")
	private int passengers;
	@JsonProperty("cost")
	private double cost;
	@JsonProperty("indicator")
	private String indicator;
	
	public CabDetails(int driverId, String driverName, String cabId,
			String cabMake, int passengers, double cost, String indicator) {
		this.driverId = driverId;
		this.driverName = driverName;
		this.cabId = cabId;
		this.cabMake = cabMake;
		this.passengers = passengers;
		this.cost = cost;
		this.indicator = indicator;
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

}
