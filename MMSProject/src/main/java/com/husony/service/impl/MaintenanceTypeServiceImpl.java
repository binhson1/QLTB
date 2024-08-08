/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Maintenancetype;
import com.husony.repository.MaintenanceTypeRepository;
import com.husony.service.MaintenanceTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class MaintenanceTypeServiceImpl implements MaintenanceTypeService{

    @Autowired
    private MaintenanceTypeRepository maintenanceTypeRepo;
    
    @Override
    public List<Maintenancetype> getMaintenanceType() {
        return this.maintenanceTypeRepo.getMaintenanceType();
    }

    @Override
    public Maintenancetype getMaintenanceTypeById(long id) {
        return this.maintenanceTypeRepo.getMaintenanceTypeById(id);
    }

    @Override
    public void addOrUpdateMaintenanceType(Maintenancetype m) {
        this.maintenanceTypeRepo.addOrUpdateMaintenanceType(m);
    }

    @Override
    public void deleteMaintenanceType(long id) {
        this.maintenanceTypeRepo.deleteMaintenanceType(id);
    }
    
    
}
