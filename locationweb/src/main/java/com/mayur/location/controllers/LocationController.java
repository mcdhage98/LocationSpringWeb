package com.mayur.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mayur.location.entities.Location;
import com.mayur.location.repositories.LocationRepository;
import com.mayur.location.services.LocationService;
import com.mayur.location.utillities.EmailUtil;
import com.mayur.location.utillities.ReportUtil;

@Controller
public class LocationController {
	
	
	@Autowired
	LocationService service;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	ReportUtil reportUtil;
	
	@RequestMapping("/showCreateLocationPage")
	public String showCreateLoocationPage()
	{
		return "createLocation";
	}
	
	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap modelMap)
	{
		//@ModelAttribute("location") 
		
		Location savedLocation = service.saveLocation(location);
		String msg="location saved with id :"+savedLocation.getId();
		modelMap.addAttribute("msg",msg);
		emailUtil.sendEmail("mcdtesttest@gmail.com", "location saved", "lacation saved succesfully");
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayAllLocations(ModelMap m)
	{
		List<Location> allLocations = service.getAllLocations();
		m.addAttribute("allLocations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") Long id,ModelMap m)
	{
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> allLocations = service.getAllLocations();
		m.addAttribute("allLocations", allLocations);
		return "displayLocations";
		
	}
	
	@RequestMapping("/updateLocation")
	public String showEditPage(@RequestParam("id") Long id,ModelMap m)
	{
		Location location= service.getLocationById(id);
		m.addAttribute("location",location	);
		return "editLocation";
	}

	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap)
	{
		service.updateLocation(location);
		List<Location> allLocations=service.getAllLocations();
		modelMap.addAttribute("allLocations", allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		String path = servletContext.getRealPath("/");
		List<Object[]> data = locationRepository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);

		return "report";
	}
}
