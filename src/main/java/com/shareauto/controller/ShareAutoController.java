package com.shareauto.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shareauto.dao.DriverDAO;
import com.shareauto.dao.PassengerDAO;
import com.shareauto.dao.RideDAO;
import com.shareauto.entities.Driver;
import com.shareauto.entities.Passenger;
import com.shareauto.entities.Ride;
import com.shareauto.model.BookRideRequest;
import com.shareauto.model.BookRideResponse;
import com.shareauto.model.CabDetails;
import com.shareauto.model.CabSearchRequest;
import com.shareauto.model.CabSearchResponse;
import com.shareauto.model.DriverRequest;
import com.shareauto.model.DriverResponse;
import com.shareauto.model.PassengerRequest;
import com.shareauto.model.PassengerResponse;
import com.shareauto.model.UpdateRideRequest;
import com.shareauto.model.UpdateRideResponse;
import com.shareauto.utils.ShareAutoUtil;

@Controller
public class ShareAutoController {
	
	private static final Logger LOGGER = Logger.getLogger(ShareAutoController.class);
	
	@Autowired
	private DriverDAO driverDao;
	
	@Autowired
	private PassengerDAO passengerDao;
	
	@Autowired
	private RideDAO rideDao;
	
	@RequestMapping(value = { "/addDriver" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<DriverResponse> addDriver(@RequestBody DriverRequest request) {
		
		Callable<DriverResponse> asyncTask = new Callable<DriverResponse>() {
			@Override
			public DriverResponse call() throws Exception {
				DriverResponse result = new DriverResponse();
				LOGGER.info("Adding driver details for: " +request.getName());
				Driver driver = new Driver(request.getName(), request.getMobileNumber(),
						request.getEmailId(), request.getGender(), request.getCity(),
						request.getCabMake(), request.getCabColor(),
						request.getCabNumber(),request.getGpsCurrent());
				driverDao.addDriver(driver);
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/addPassenger" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<PassengerResponse> addPassenger(@RequestBody PassengerRequest request) {
		
		Callable<PassengerResponse> asyncTask = new Callable<PassengerResponse>() {
			@Override
			public PassengerResponse call() throws Exception {
				PassengerResponse result = new PassengerResponse();
				LOGGER.info("Adding Passenger details for: " +request.getName());
				Passenger passenger = new Passenger(request.getName(), request.getMobileNumber(),
						request.getEmailId(), request.getGender(), request.getCity(), request.getGpsCurrent());
				passengerDao.addPassenger(passenger);
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/addRide" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<BookRideResponse> addRide(@RequestBody BookRideRequest request) {
		
		Callable<BookRideResponse> asyncTask = new Callable<BookRideResponse>() {
			@Override
			public BookRideResponse call() throws Exception {
				BookRideResponse result = new BookRideResponse();
				List<Integer> users = new ArrayList<>();
				users.add(request.getUserId());
				LOGGER.info("Adding ride details for: " +request.getDriverId()
						+"/"+request.getUserId());
				Ride ride = new Ride(Calendar.getInstance(), request.getDriverId(), users,
						request.getGpsStart(), request.getGpsEnd(), request.getCost());
				rideDao.addRide(ride);
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/updateRide" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<UpdateRideResponse> updateRide(@RequestBody UpdateRideRequest request) {
		
		Callable<UpdateRideResponse> asyncTask = new Callable<UpdateRideResponse>() {
			@Override
			public UpdateRideResponse call() throws Exception {
				UpdateRideResponse result = new UpdateRideResponse();
				Ride ride = rideDao.fetchRide(request.getRideId());
				List<Integer> users = ride.getUsers();
				users.add(request.getUserId());
				LOGGER.info("Updating ride details for: " +request.getUserId());
				rideDao.addRide(ride);
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/searchCabs" }, method = RequestMethod.GET, produces = "application/json")
	public Callable<CabSearchResponse> searchCabs(@RequestBody CabSearchRequest request) {
		String gpsStart = request.getGpsStart();
		String gpsEnd = request.getGpsEnd();
		
		
		Callable<CabSearchResponse> asyncTask = new Callable<CabSearchResponse>() {
			@Override
			public CabSearchResponse call() throws Exception {
				CabSearchResponse result = new CabSearchResponse();

				double lat1 = Double.valueOf(StringUtils.substringBefore(gpsStart, ","));
				double lon1 = Double.valueOf(StringUtils.substringAfter(gpsStart,","));
				double lat2 = Double.valueOf(StringUtils.substringBefore(gpsEnd, ","));
				double lon2 = Double.valueOf(StringUtils.substringAfter(gpsEnd,","));
				//Calculate km using gpsStart and gpsEnd
				double km = ShareAutoUtil.distance(lat1, lon1, lat2, lon2, "K");
				double cost = 10 * km;
				List<Passenger> passengers = passengerDao.findPassengers(gpsStart, gpsEnd);
				String indicator = "red";
				if(passengers.size() >= 3) {
					indicator = "green";
				} else if(passengers.size() >= 1) {
					indicator = "yellow";
				}
				List<CabDetails> cabDetails = new ArrayList<>();
				List<Driver> drivers = driverDao.findDrivers(gpsStart);
				for(Driver driver: drivers) {
					CabDetails cab = new CabDetails(driver.getId(), driver.getName(), driver.getCabNumber(),
							driver.getMake(), 0, cost, indicator);
					cabDetails.add(cab);
				}
				List<Ride> rides = rideDao.findRides(gpsStart, gpsEnd);
				for(Ride ride:rides){
					Driver driver = driverDao.fetchDriver(ride.getDriverId());
					int seatsFilled = ride.getUsers().size();
					if((seatsFilled >=3 && passengers.size() >= 1) || (seatsFilled >=2 && passengers.size() >= 2) || (seatsFilled >=1 && passengers.size() >= 3)) {
						indicator = "green";
					} else if((seatsFilled >=2 && passengers.size() >= 1) || (seatsFilled >=1 && passengers.size() >= 2)) {
						indicator = "yellow";
					}
					CabDetails cab = new CabDetails(ride.getDriverId(), driver.getName(), driver.getCabNumber(),
							driver.getMake(), seatsFilled, cost, indicator);
					cabDetails.add(cab);
				}
				result.setCabs(cabDetails);
				LOGGER.info("Found cabs : " +cabDetails.size());
				return result;
			}
		};
		return asyncTask;
	}
	
	
	

}
