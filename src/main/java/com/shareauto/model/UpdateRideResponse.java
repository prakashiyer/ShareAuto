package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRideResponse {
	
	@JsonProperty("id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
