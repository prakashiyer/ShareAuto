package com.shareauto.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerResponse {
	
	@JsonProperty("id")
	private String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
