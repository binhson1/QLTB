/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Location;
import java.util.List;

/**
 *
 * @author Do Gia Huy
 */
public interface LocationRepository {
    List<Location> getLocations();
    void addOrUpdate(Location l);
    void deleteLocation(long id);
    Location getLocationById(long id);
}
