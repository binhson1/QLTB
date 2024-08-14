/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;
import com.husony.repository.DeviceRepository;
import com.husony.service.DeviceService;
import com.husony.service.LocationHistoryService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepo;

    @Autowired
    private LocationHistoryService locationHistoryService;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Device> getDevices(Map<String, String> params) {
        List<Device> devices = this.deviceRepo.getDevices(params);
        devices = devices.stream()
                .map(device -> {
                    Locationhistory location = this.locationHistoryService.getLocationByDevice(device);
                    device.setLocation(location.getLocationId());
                    return device;
                })
                .collect(Collectors.toList());

        return devices;
    }

    @Override
    public void addOrUpdate(Device d) {
        if (d.getFile() != null) {
            if (!d.getFile().isEmpty()) {
                try {
                    Map res = this.cloudinary.uploader().upload(d.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));

                    d.setImage(res.get("secure_url").toString());
                } catch (IOException ex) {
                    Logger.getLogger(DeviceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.deviceRepo.addOrUpdate(d);
    }

    @Override
    public Device getDeviceById(long id) {
        Device device = this.deviceRepo.getDeviceById(id);
        Locationhistory location = this.locationHistoryService.getLocationByDevice(device);
        device.setLocation(location.getLocationId());
        return device;
    }

    @Override
    public void deleteDevice(long l) {
        this.deviceRepo.deleteDevice(l);
    }

//    @Scheduled(cron = ngay)
//    public void scheduleFixedDelayTask() {
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 1000);
//    }
}
