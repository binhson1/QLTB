/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Device;
import java.util.List;

/**
 *
 * @author Do Gia Huy
 */
public interface DeviceRepository {
    List<Device> getDevices();
    void addOrUpdate(Device d);
    Device getDeviceById(long id);
    void deleteDevice(long id);
}
