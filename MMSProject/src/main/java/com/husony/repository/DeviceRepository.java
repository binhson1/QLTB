/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Device;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */
public interface DeviceRepository {
    List<Device> getDevices(Map<String, String> params);
    void addOrUpdate(Device d);
    Device getDeviceById(long id);
    void deleteDevice(long id);
}
