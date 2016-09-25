package com.shareauto.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity object for Driver table
 *
 */
@Entity
@Table(name="ride")
public class Ride {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Calendar date;
	@Column(name="driverId")
	private int driverId;
	@Column(name="users")
	private String users;
	@Column(name="gpsStartLat")
	private double gpsStartLat;
	@Column(name="gpsStartLon")
	private double gpsStartLon;
	@Column(name="gpsEndLat")
	private double gpsEndLat;
	@Column(name="gpsEndLon")
	private double gpsEndLon;
	@Column(name="gpsCurrentLat")
	private double gpsCurrentLat;
	@Column(name="gpsCurrentLon")
	private double gpsCurrentLon;
	@Column(name="cost")
	private double cost;
	
	public Ride() {
		
	}
	
	public Ride(Calendar date, int driverId, String users,
			double gpsStartLat, double gpsStartLon,
			double gpsEndLat, double gpsEndLon, double cost,
			double gpsCurrentLat, double gpsCurrentLon) {
		this.date = date;
		this.driverId = driverId;
		this.users = users;
		this.gpsStartLat = gpsStartLat;
		this.gpsStartLon = gpsStartLon;
		this.gpsEndLat = gpsEndLat;
		this.gpsEndLon = gpsEndLon;
		this.cost = cost;
		this.gpsCurrentLat = gpsCurrentLat;
		this.gpsCurrentLon = gpsCurrentLon;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Calendar getDate() {
		return date;
	}


	public void setDate(Calendar date) {
		this.date = date;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}


	public String getUsers() {
		return users;
	}


	public void setUsers(String users) {
		this.users = users;
	}

	public double getGpsStartLat() {
		return gpsStartLat;
	}


	public void setGpsStartLat(double gpsStartLat) {
		this.gpsStartLat = gpsStartLat;
	}


	public double getGpsStartLon() {
		return gpsStartLon;
	}


	public void setGpsStartLon(double gpsStartLon) {
		this.gpsStartLon = gpsStartLon;
	}


	public double getGpsEndLat() {
		return gpsEndLat;
	}


	public void setGpsEndLat(double gpsEndLat) {
		this.gpsEndLat = gpsEndLat;
	}


	public double getGpsEndLon() {
		return gpsEndLon;
	}


	public void setGpsEndLon(double gpsEndLon) {
		this.gpsEndLon = gpsEndLon;
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
