/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.DeviceMaintenance;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */
public interface Device_MaintenanceService {
    List<DeviceMaintenance> getDeviceMaintenance(Map<String, String> params);
    void addOrUpdate(DeviceMaintenance c);
    DeviceMaintenance getDeviceMaintenanceById(long id);
    void deleteDeviceMaintenance(long id);
    DeviceMaintenance getDeviceMaintenanceByDeviceAndMaintenance(long deviceId, long scheduleMaintenanceId);
}
