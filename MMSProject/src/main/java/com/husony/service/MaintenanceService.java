/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Schedulemaintenance;
import java.util.List;

/**
 *
 * @author Do Gia Huy
 */
public interface MaintenanceService {
    List<Schedulemaintenance> getMaintenance();
    void addOrUpdate(Schedulemaintenance d);
    Schedulemaintenance getMaintenanceById(long id);
    void deleteMaintenance(long id);
}
