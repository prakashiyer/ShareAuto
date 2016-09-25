package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverResponse {
	
	@JsonProperty("id")
	private int id;
	@JsonProperty("cabId")
	private String cabId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCabId() {
		return cabId;
	}
	
	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

}
