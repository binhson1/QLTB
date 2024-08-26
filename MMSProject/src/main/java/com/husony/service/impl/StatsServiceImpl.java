/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.repository.StatsRepository;
import com.husony.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class StatsServiceImpl implements StatsService{
    
    @Autowired
    private StatsRepository statsRepo;
    
    @Override
    public List<Object[]> statsRevenueByDevice() {
        List<Object[]> stats = this.statsRepo.statsRevenueByDevice();
        return stats;
    }

    @Override
    public List<Object[]> statsDeviceByCategory() {
        return this.statsRepo.statsDeviceByCategory();
    }

    @Override
    public List<Object[]> statsDeviceByStatus() {
        return this.statsRepo.statsDeviceByStatus();
    }

    @Override
    public List<Object[]> statsRepairCostDevice() {
        return this.statsRepo.statsRepairCostDevice();
    }
    
}
