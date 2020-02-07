package com.mayur.location.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mayur.location.entities.Location;
import com.mayur.location.repositories.LocationRepository;


@RequestMapping("/locations")
@RestController
public class LocationRestController {

	@Autowired
	LocationRepository locationRepository;
	
	
	@GetMapping
	public List<Location>getLocations()
	{
		return locationRepository.findAll();
	}
	
	@PostMapping
	public Location createLocation(@RequestBody Location location)
	{
		return locationRepository.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location)
	{
		return locationRepository.save(location);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") Long id)
	{
		locationRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") Long id)
	{
		Optional<Location> optionalLocation= locationRepository.findById(id);
		if(optionalLocation.isPresent())
			return optionalLocation.get();
		else
			return null;
	}
}
