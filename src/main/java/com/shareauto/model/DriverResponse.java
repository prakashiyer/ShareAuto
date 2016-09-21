package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverResponse {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("cab_id")
	private int cabId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCabId() {
		return cabId;
	}
	
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}

}
