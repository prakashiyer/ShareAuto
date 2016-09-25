package com.shareauto.dao;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shareauto.entities.Passenger;

@Repository
@Transactional
public class PassengerDAO {

	private static final Logger LOGGER = Logger.getLogger(PassengerDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Passenger fetchPassenger(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Passenger passenger = (Passenger) session.load(Passenger.class, id);
		LOGGER.info("Passenger loaded successfully, Passenger details="+passenger.getId() + "/" 
				+ passenger.getName() + "/" + passenger.getMobileNumber());
		return passenger;
	}

	public Passenger addPassenger(Passenger passenger) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(passenger);
		LOGGER.info("Passenger loaded successfully, Passenger details="+passenger.getId() + "/" 
				+ passenger.getName() + "/" + passenger.getMobileNumber());
		return passenger;
	}
		
	@SuppressWarnings("unchecked")
	public List<Passenger> findPassengersNearby(double gpsCurrentLat, double gpsCurrentLon) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("FROM Passenger WHERE (:lat - gpsCurrentLat) <= 0.01 AND (:lon - gpsCurrentLon) <= 0.01");
		query.setDouble("lat", gpsCurrentLat);
		query.setDouble("lon", gpsCurrentLon);
		List<Passenger> passengers = Collections.checkedList(query.list(), Passenger.class);
		LOGGER.info("Passengers found successfully, Passengers list size="+passengers.size());
		return passengers;
	}
}
