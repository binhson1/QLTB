/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Schedulemaintenance;
import com.husony.repository.MaintenanceRepository;
import com.husony.service.MaintenanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class MaintenanceServiceImpl implements MaintenanceService {
    
    @Autowired
    private MaintenanceRepository maintenanceRepo;

    @Override
    public List<Schedulemaintenance> getMaintenance() {
        return this.maintenanceRepo.getMaintenance();
    }

    @Override
    public void addOrUpdate(Schedulemaintenance d) {
        this.maintenanceRepo.addOrUpdate(d);
    }

    @Override
    public Schedulemaintenance getMaintenanceById(long id) {
        return this.maintenanceRepo.getMaintenanceById(id);
    }

    @Override
    public void deleteMaintenance(long id) {
        this.maintenanceRepo.deleteMaintenance(id);
    }
    
}
