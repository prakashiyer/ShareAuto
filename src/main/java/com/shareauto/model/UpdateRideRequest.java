package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRideRequest {
	
	@JsonProperty("ride_id")
	private int rideId;
	@JsonProperty("user_id")
	private int userId;

	
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
