package com.shareauto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity object for Driver table
 *
 */
@Entity
@Table(name="driver")
public class Driver {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="mobileNumber")
	private int mobileNumber;
	@Column(name="email_id")
	private String emailId;
	@Column(name="gender")
	private String gender;
	@Column(name="city")
	private String city;
	@Column(name="make")
	private String make;
	@Column(name="color")
	private String color;
	@Column(name="cabNumber")
	private String cabNumber;
	@Column(name="gpsCurrent")
	private String gpsCurrent;
	
	
	public Driver(String name, int mobileNumber, String emailId, String gender, 
			String city, String make, String color, String cabNumber, String gpsCurrent) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.gender = gender;
		this.city = city;
		this.make = make;
		this.color = color;
		this.cabNumber = cabNumber;
		this.gpsCurrent = gpsCurrent;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getCabNumber() {
		return cabNumber;
	}


	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}


	public String getGpsCurrent() {
		return gpsCurrent;
	}


	public void setGpsCurrent(String gpsCurrent) {
		this.gpsCurrent = gpsCurrent;
	}
	
}
