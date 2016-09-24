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

import com.shareauto.entities.Ride;

@Repository
@Transactional
public class RideDAO {

	private static final Logger LOGGER = Logger.getLogger(RideDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Ride fetchRide(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Ride ride = (Ride) session.load(Ride.class, id);
		LOGGER.info("Ride loaded successfully, Driver details="+ride.getId() + "/" 
				+ ride.getDriverId() );
		return ride;
	}

	public void addRide(Ride ride) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(ride);
		LOGGER.info("Ride saved successfully, ride Details="+ ride.getDriverId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Ride> findRides(double gpsStartLat, double gpsStartLon, double gpsEndLat, double gpsEndLon) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("select * from ride where gpsStart >= ? and gpsEnd <=?");
		query.setParameter(1, gpsStartLat);
		query.setParameter(2, gpsStartLon);
		query.setParameter(3, gpsEndLat);
		query.setParameter(4, gpsEndLon);
		List<Ride> rides = Collections.checkedList(query.list(), Ride.class);
		LOGGER.info("Rides found successfully, Rides list size="+rides.size());
		return rides;
	}
}
