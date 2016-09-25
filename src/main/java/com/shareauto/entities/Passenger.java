package com.shareauto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity object for Passenger table
 *
 */
@Entity
@Table(name="user")
public class Passenger {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	@Column(name="mobileNumber")
	private int mobileNumber;
	@Column(name="emailId")
	private String emailId;
	@Column(name="gender")
	private String gender;
	@Column(name="city")
	private String city;
	@Column(name="gpsCurrentLat")
	private double gpsCurrentLat;
	@Column(name="gpsCurrentLon")
	private double gpsCurrentLon;
	
	public Passenger() {
		
	}
	
	public Passenger(String name, int mobileNumber, String emailId, String gender,
			String city, double gpsCurrentLat, double gpsCurrentLon) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.gender = gender;
		this.city = city;
		this.gpsCurrentLat = gpsCurrentLat;
		this.gpsCurrentLon = gpsCurrentLon;
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
