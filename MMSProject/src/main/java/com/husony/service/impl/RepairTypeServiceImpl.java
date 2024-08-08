/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Repairtype;
import com.husony.repository.RepairTypeRepository;
import com.husony.service.RepairTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class RepairTypeServiceImpl implements RepairTypeService{
    
    @Autowired
    private RepairTypeRepository repairTypeRepo;
    
    @Override
    public List<Repairtype> getRepairType() {
        return this.repairTypeRepo.getRepairType();
    }

    @Override
    public Repairtype getRepairTypeById(long id) {
        return this.repairTypeRepo.getRepairTypeById(id);
    }

    @Override
    public void addOrUpdateRepairType(Repairtype r) {
        this.repairTypeRepo.addOrUpdateRepairType(r);
    }

    @Override
    public void deleteRepairType(long id) {
        this.repairTypeRepo.deleteRepairType(id);
    }
    
}
