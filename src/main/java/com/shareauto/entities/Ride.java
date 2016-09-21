package com.shareauto.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Calendar date;
	@Column(name="driverId")
	private int driverId;
	@Column(name="users")
	private List<Integer> users;
	@Column(name="gpsStart")
	private String gpsStart;
	@Column(name="gpsEnd")
	private String gpsEnd;
	@Column(name="cost")
	private double cost;
	
	
	public Ride(Calendar date, int driverId, List<Integer> users, String gpsStart, String gpsEnd, double cost) {
		this.date = date;
		this.driverId = driverId;
		this.users = users;
		this.gpsStart = gpsStart;
		this.gpsEnd = gpsEnd;
		this.cost = cost;
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


	public List<Integer> getUsers() {
		return users;
	}


	public void setUsers(List<Integer> users) {
		this.users = users;
	}


	public String getGpsStart() {
		return gpsStart;
	}


	public void setGpsStart(String gpsStart) {
		this.gpsStart = gpsStart;
	}


	public String getGpsEnd() {
		return gpsEnd;
	}


	public void setGpsEnd(String gpsEnd) {
		this.gpsEnd = gpsEnd;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}

	

}
