package com.shareauto.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
import com.shareauto.model.UpdateLocationRequest;
import com.shareauto.model.UpdateLocationResponse;
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
	
	
	@RequestMapping(value = { "/getDriver" }, method = RequestMethod.GET, produces = "application/json")
	public Callable<DriverResponse> getDriver() {
		
		Callable<DriverResponse> asyncTask = new Callable<DriverResponse>() {
			@Override
			public DriverResponse call() throws Exception {
				DriverResponse result = new DriverResponse();
				Driver driver = driverDao.fetchDriver(1);
				result.setId(driver.getId());
				result.setCabId(driver.getCabNumber());
				return result;
			}
		};
		return asyncTask;
	}
	
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
						request.getCabNumber(),request.getGpsCurrentLat(),
						request.getGpsCurrentLon());
				driver = driverDao.addDriver(driver);
				result.setId(driver.getId());
				result.setCabId(driver.getCabNumber());
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/updateLocation" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<UpdateLocationResponse> updateDriverLocation(
			@RequestBody UpdateLocationRequest request) {
		
		Callable<UpdateLocationResponse> asyncTask = new Callable<UpdateLocationResponse>() {
			@Override
			public UpdateLocationResponse call() throws Exception {
				UpdateLocationResponse result = new UpdateLocationResponse();
				LOGGER.info("Adding driver details for: " +request.getId());
				if("driver".equals(request.getType())) {
					Driver driver = driverDao.fetchDriver(request.getId());
					driver.setGpsCurrentLat(request.getGpsCurrentLat());
					driver.setGpsCurrentLon(request.getGpsCurrentLon());
					driver = driverDao.addDriver(driver);
					result.setId(driver.getId());
				} else if ("user".equals(request.getType())) {
					Passenger passenger = passengerDao.fetchPassenger(request.getId());
					passenger.setGpsCurrentLat(request.getGpsCurrentLat());
					passenger.setGpsCurrentLon(request.getGpsCurrentLon());
					passenger = passengerDao.addPassenger(passenger);
					result.setId(passenger.getId());
				} else if ("ride".equals(request.getType())) {
					Ride ride = rideDao.fetchRide(request.getId());
					ride.setGpsCurrentLat(request.getGpsCurrentLat());
					ride.setGpsCurrentLon(request.getGpsCurrentLon());
					ride = rideDao.addRide(ride);
					result.setId(ride.getId());
				}
				
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/addUser" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<PassengerResponse> addPassenger(@RequestBody PassengerRequest request) {
		
		Callable<PassengerResponse> asyncTask = new Callable<PassengerResponse>() {
			@Override
			public PassengerResponse call() throws Exception {
				PassengerResponse result = new PassengerResponse();
				LOGGER.info("Adding Passenger details for: " +request.getName());
				Passenger passenger = new Passenger(request.getName(), request.getMobileNumber(),
						request.getEmailId(), request.getGender(), request.getCity(),
						request.getGpsCurrentLat(), request.getGpsCurrentLon());
				passenger = passengerDao.addPassenger(passenger);
				result.setId(passenger.getId());
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
				List<String> users = new ArrayList<>();
				users.add(request.getUserId());
				LOGGER.info("Adding ride details for: " +request.getDriverId()
						+"/"+request.getUserId());
				Ride ride = new Ride(Calendar.getInstance(), request.getDriverId(), StringUtils.collectionToCommaDelimitedString(users),
						request.getGpsStartLat(), request.getGpsStartLon(),
						request.getGpsEndLat(), request.getGpsEndLon(),
						request.getCost(), request.getGpsCurrentLat(), request.getGpsCurrentLon());
				ride = rideDao.addRide(ride);
				result.setId(ride.getId());
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
				String users = ride.getUsers();
				users = users +","+String.valueOf(request.getUserId());
				ride.setUsers(users);
				LOGGER.info("Updating ride details for: " +request.getUserId());
				ride = rideDao.addRide(ride);
				result.setId(ride.getId());
				return result;
			}
		};
		return asyncTask;
	}
	
	@RequestMapping(value = { "/searchCabs" }, method = RequestMethod.POST, produces = "application/json")
	public Callable<CabSearchResponse> searchCabs(@RequestBody CabSearchRequest request) {
		
		Callable<CabSearchResponse> asyncTask = new Callable<CabSearchResponse>() {
			@Override
			public CabSearchResponse call() throws Exception {
				CabSearchResponse result = new CabSearchResponse();

				//Calculate km using gpsStart and gpsEnd
				double km = ShareAutoUtil.distance(request.getGpsStartLat(), request.getGpsStartLon(),
						request.getGpsEndLat(), request.getGpsEndLon(), "K");
				double cost = 10 * km;
				List<Passenger> passengers = passengerDao.findPassengersNearby(request.getGpsCurrentLat(), request.getGpsCurrentLon());
				String indicator = "red";
				if(passengers.size() >= 3) {
					indicator = "green";
				} else if(passengers.size() >= 1) {
					indicator = "yellow";
				}
				List<CabDetails> cabDetails = new ArrayList<>();
				List<Driver> drivers = driverDao.findDrivers(request.getGpsStartLat(), request.getGpsStartLon());
				for(Driver driver: drivers) {
					CabDetails cab = new CabDetails(driver.getId(), driver.getName(), driver.getCabNumber(),
							driver.getMake(), 0, cost, indicator, driver.getGpsCurrentLat(), driver.getGpsCurrentLon());
					cabDetails.add(cab);
				}
				List<Ride> rides = rideDao.findRides(request.getGpsStartLat(), request.getGpsStartLon());
				for(Ride ride:rides){
					Driver driver = driverDao.fetchDriver(ride.getDriverId());
					int seatsFilled = StringUtils.commaDelimitedListToSet(ride.getUsers()).size();
					if((seatsFilled >=3 && passengers.size() >= 1) || (seatsFilled >=2 && passengers.size() >= 2) || (seatsFilled >=1 && passengers.size() >= 3)) {
						indicator = "green";
					} else if((seatsFilled >=2 && passengers.size() >= 1) || (seatsFilled >=1 && passengers.size() >= 2)) {
						indicator = "yellow";
					}
					CabDetails cab = new CabDetails(driver.getId(), driver.getName(), driver.getCabNumber(),
							driver.getMake(), seatsFilled, cost, indicator, driver.getGpsCurrentLat(), driver.getGpsCurrentLon());
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
