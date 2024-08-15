/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Schedulerepair;
import com.husony.repository.ScheduleRepairRepository;
import com.husony.service.ScheduleRepairService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class ScheduleRepairServiceImpl implements ScheduleRepairService{
    
    @Autowired
    private ScheduleRepairRepository schedulerepairRepo;

    @Override
    public List<Schedulerepair> getScheduleRepair(Map<String, String> params) {
        return this.schedulerepairRepo.getScheduleRepair(params);
    }

    @Override
    public Schedulerepair getScheduleRepairById(long id) {
        return this.schedulerepairRepo.getScheduleRepairById(id);
    }

    @Override
    public void deleteScheduleRepair(long id) {
        this.schedulerepairRepo.deleteScheduleRepair(id);
    }

    @Override
    public void addOrUpdateScheduleRepair(Schedulerepair r) {
        this.schedulerepairRepo.addOrUpdateScheduleRepair(r);
    }

    @Override
    public List<Schedulerepair> getScheduleRepairByDeviceId(long id) {
        return this.schedulerepairRepo.getScheduleRepairByDeviceId(id);
    }
    
}
