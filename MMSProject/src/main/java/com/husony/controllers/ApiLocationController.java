/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.pojo.Location;
import com.husony.service.LocationHistoryService;
import com.husony.service.LocationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiLocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationHistoryService locationHistoryService;

    @DeleteMapping("/location/delete/{locationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "locationId") long id) {
        this.locationService.deleteLocation(id);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.locationService.getLocations(params), HttpStatus.OK);
    }

    @GetMapping("/location/{locationId}/device")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Device>> getDevicesByLocation(@PathVariable(value = "locationId") long id) {
        return new ResponseEntity<>(this.locationHistoryService.getDevicesByLocation(id), HttpStatus.OK);
    }
    
    @GetMapping("/locations/{locationId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Location> getLocationById(@PathVariable(value = "locationId") long id) {
        return new ResponseEntity<>(this.locationService.getLocationById(id), HttpStatus.OK);
    }
}
