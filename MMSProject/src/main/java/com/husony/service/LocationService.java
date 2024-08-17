/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Location;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */
public interface LocationService {
    List<Location> getLocations(Map<String, String> params);
    void addOrUpdate(Location l);
    void deleteLocation(long id);
    Location getLocationById(long id);
}
