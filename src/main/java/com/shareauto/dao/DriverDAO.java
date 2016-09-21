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

import com.shareauto.entities.Driver;

@Repository
@Transactional
public class DriverDAO {

	private static final Logger LOGGER = Logger.getLogger(DriverDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Driver fetchDriver(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Driver driver = (Driver) session.load(Driver.class, id);
		LOGGER.info("Driver loaded successfully, Driver details="+driver.getId() + "/" 
				+ driver.getName() + "/" + driver.getMobileNumber());
		return driver;
	}

	public void addDriver(Driver driver) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(driver);
		LOGGER.info("Driver saved successfully, Driver Details="+driver.getId() + "/" 
				+ driver.getName() + "/" + driver.getMobileNumber());
	}
	
	@SuppressWarnings("unchecked")
	public List<Driver> findDrivers(String gps) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query query = session.createQuery("select * from driver where gpsCurrent > ?");
		query.setParameter(1, gps);
		List<Driver> drivers = Collections.checkedList(query.list(), Driver.class);
		LOGGER.info("Drivers found successfully, Drivers list size="+drivers.size());
		return drivers;
	}
}
