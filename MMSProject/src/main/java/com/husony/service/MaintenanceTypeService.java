/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Maintenancetype;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MaintenanceTypeService {
    List<Maintenancetype> getMaintenanceType();
    Maintenancetype getMaintenanceTypeById(long id);
    void addOrUpdateMaintenanceType(Maintenancetype m);
    void deleteMaintenanceType(long id);
}
