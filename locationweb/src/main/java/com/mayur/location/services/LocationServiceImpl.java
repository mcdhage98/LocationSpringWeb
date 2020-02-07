package com.mayur.location.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayur.location.entities.Location;
import com.mayur.location.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location)//incoming location is updated
	{
		return locationRepository.save(location);
		
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepository.delete(location);

	}

	@Override
	public Location getLocationById(Long id) {
		Optional<Location> optionalLocation=locationRepository.findById(id);
		if(optionalLocation.isPresent())
		{
			return optionalLocation.get();
		}
		else
			return null;
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}

}
