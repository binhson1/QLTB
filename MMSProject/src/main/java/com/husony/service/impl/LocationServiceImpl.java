/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Location;
import com.husony.repository.LocationRepository;
import com.husony.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepo;

    @Override
    public List<Location> getLocations() {
        return this.locationRepo.getLocations();
    }

    @Override
    public void addOrUpdate(Location l) {
        this.locationRepo.addOrUpdate(l);
    }

    @Override
    public Location getLocationById(long l) {
        return this.locationRepo.getLocationById(l);
    }

    @Override
    public void deleteLocation(long id) {
        this.locationRepo.deleteLocation(id);
    }
    
}
