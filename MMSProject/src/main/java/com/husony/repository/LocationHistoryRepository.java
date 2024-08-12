/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;
import java.util.List;

/**
 *
 * @author Do Gia Huy
 */
public interface LocationHistoryRepository {
    Locationhistory getLocationByDevice(Device d);
    void createLocationDevice(Locationhistory l);
    void updateLocationDevice(Locationhistory l);
    List<Locationhistory> getDevicesByLocation(long id);
    List<Locationhistory> getLocationHistoryByDevice(long id);
}
