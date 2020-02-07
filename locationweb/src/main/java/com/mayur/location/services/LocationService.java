package com.mayur.location.services;

import java.util.List;

import com.mayur.location.entities.Location;



public interface LocationService {
	
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	Location getLocationById(Long id);
	List<Location> getAllLocations();

}
