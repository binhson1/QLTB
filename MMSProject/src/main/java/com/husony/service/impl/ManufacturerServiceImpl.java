/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Manufacturer;
import com.husony.repository.ManufacturerRepository;
import com.husony.service.ManufacturerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ManufacturerServiceImpl implements ManufacturerService{

    @Autowired
    private ManufacturerRepository manuRepo;
    
    @Override
    public List<Manufacturer> getManufac() {
        return this.manuRepo.getManufac();
    }    

    @Override
    public void addOrUpdateManu(Manufacturer m) {
        this.manuRepo.addOrUpdateManu(m);
    }

    @Override
    public void deleteManu(long id) {
        this.manuRepo.deleteManu(id);
    }

    @Override
    public Manufacturer getManuById(long id) {
        return this.manuRepo.getManuById(id);
    }
}
