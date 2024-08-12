/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;
import com.husony.repository.LocationHistoryRepository;
import com.husony.service.LocationHistoryService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class LocationHistoryServiceImpl implements LocationHistoryService {

    @Autowired
    private LocationHistoryRepository locationHistoryRepo;

    @Override
    public Locationhistory getLocationByDevice(Device d) {
        return this.locationHistoryRepo.getLocationByDevice(d);
    }

    @Override
    public void createLocationDevice(Locationhistory l) {
        this.locationHistoryRepo.createLocationDevice(l);
    }

    @Override
    public void updateLocationDevice(Locationhistory l) {
        this.locationHistoryRepo.updateLocationDevice(l);
    }

    @Override
    public List<Device> getDevicesByLocation(long id) {
        List<Locationhistory> list = this.locationHistoryRepo.getDevicesByLocation(id);
        List<Device> devices = list.stream()
                .map(Locationhistory::getDeviceId) // Convert Locationhistory to Device
                .collect(Collectors.toList());
        return devices;
    }

    @Override
    public List<Locationhistory> getLocationHistoryByDevice(long id) {
        return this.locationHistoryRepo.getLocationHistoryByDevice(id);
    }
}
