/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;

/**
 *
 * @author Do Gia Huy
 */
public interface LocationHistoryService {
    Locationhistory getLocationByDevice(Device d);
    void createLocationDevice(Locationhistory l);
    void updateLocationDevice(Locationhistory l);
}
