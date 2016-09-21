package com.shareauto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CabSearchResponse {
	
	@JsonProperty("cabs")
	private List<CabDetails> cabs;

	public List<CabDetails> getCabs() {
		return cabs;
	}

	public void setCabs(List<CabDetails> cabs) {
		this.cabs = cabs;
	}

}
