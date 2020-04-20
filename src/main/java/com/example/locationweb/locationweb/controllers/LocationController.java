package com.example.locationweb.locationweb.controllers;

import com.example.locationweb.locationweb.entities.Location;
import com.example.locationweb.locationweb.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping("/showCreate")
    public String createLocation(){
        return "createLocations";
    }

    @RequestMapping("/saveLoc")
    public  String saveLocation(Model model,  Location location){
        model.addAttribute("message",location.getName()+" you are added");
        locationService.saveLocation(location);

        return "createLocations";
    }

    @RequestMapping("/displayLocations")
    public String displayAllLocations(Model model){
        List<Location> locList= locationService.getAllLocations();
        model.addAttribute("locationAll",locList);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation/{id}")
    public String deleteLocations(@PathVariable("id") Long id)
    {
        locationService.deleteLocationById(id);
        return "redirect:";

    }

}
