/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Schedulemaintenance;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */
public interface MaintenanceRepository {
    List<Schedulemaintenance> getMaintenance(Map<String, String> params);
    void addOrUpdate(Schedulemaintenance d);
    Schedulemaintenance getMaintenanceById(long id);
    void deleteMaintenance(long id);
}
