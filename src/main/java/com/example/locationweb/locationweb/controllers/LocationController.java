package com.example.locationweb.locationweb.controllers;

import com.example.locationweb.locationweb.entities.Location;
import com.example.locationweb.locationweb.services.LocationService;
import com.example.locationweb.locationweb.utilities.MailUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private MailUtility mailUtility;

    @RequestMapping("/showCreate")
    public String createLocation(){
        return "createLocations";
    }

    @RequestMapping("/saveLoc")
    public  String saveLocation(@ModelAttribute("location")Location location, Model model){
        model.addAttribute("message",location.getName()+" you are added");
        locationService.saveLocation(location);
        mailUtility.sendEmail("tripathi01subham@gmail.com","Location Saved for: ",model.getAttribute("message").toString());

        return "createLocations";
    }

    @RequestMapping("/displayLocations")
    public String displayAllLocations(Model model){
        List<Location> locList= locationService.getAllLocations();
        model.addAttribute("locationAll",locList);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation/{id}")
    public String deleteLocations(@PathVariable("id") Long id, Model model) //please notice carefully how we have also regenerated the list of location and how we have redirected
    {
       // Long i=Long.valueOf(id);
        Location l= locationService.getLocationById(id);
        locationService.deleteLocation(l);
        List<Location> locList=locationService.getAllLocations();
        model.addAttribute("locationAll",locList);

        return "displayLocations";

    }

}
