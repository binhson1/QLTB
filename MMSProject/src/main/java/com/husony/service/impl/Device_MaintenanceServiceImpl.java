/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.DeviceMaintenance;
import com.husony.repository.Device_MaintenanceRepository;
import com.husony.service.Device_MaintenanceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class Device_MaintenanceServiceImpl implements Device_MaintenanceService {
    @Autowired
    private Device_MaintenanceRepository deviceMaintenanceRepo;

    @Override
    public List<DeviceMaintenance> getDeviceMaintenance(Map<String, String> params) {
        return this.deviceMaintenanceRepo.getDeviceMaintenance(params);
    }

    @Override
    public void addOrUpdate(DeviceMaintenance c) {
        this.deviceMaintenanceRepo.addOrUpdate(c);
    }

    @Override
    public DeviceMaintenance getDeviceMaintenanceById(long id) {
        return this.deviceMaintenanceRepo.getDeviceMaintenanceById(id);
    }

    @Override
    public void deleteDeviceMaintenance(long id) {
        this.deviceMaintenanceRepo.deleteDeviceMaintenance(id);
    }

    @Override
    public DeviceMaintenance getDeviceMaintenanceByDeviceAndMaintenance(long deviceId, long scheduleMaintenanceId) {
        return this.deviceMaintenanceRepo.getDeviceMaintenanceByDeviceAndMaintenance(deviceId, scheduleMaintenanceId);
    }
    
}
