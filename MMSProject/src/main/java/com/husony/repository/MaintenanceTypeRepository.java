/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Maintenancetype;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface MaintenanceTypeRepository {
    List<Maintenancetype> getMaintenanceType();
    Maintenancetype getMaintenanceTypeById(int id);
    void addOrUpdateMaintenanceType(Maintenancetype m);
    void deleteMaintenanceType(int id);
}
