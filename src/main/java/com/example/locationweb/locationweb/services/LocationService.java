package com.example.locationweb.locationweb.services;

import com.example.locationweb.locationweb.entities.Location;
import com.example.locationweb.locationweb.repositories.LocationRepository;

import java.util.List;

public interface LocationService  {

    Location findByName(String name);

    Location saveLocation(Location location);
    Location updateLocation(Location location);
    void deleteLocation(Location location);
    Location getLocationById(Long id);
    List<Location> getAllLocations();
    void deleteLocationById(Long id);

}
