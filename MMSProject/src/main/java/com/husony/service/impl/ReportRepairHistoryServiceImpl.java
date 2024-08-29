/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Reportrepairhistory;
import com.husony.repository.ReportRepairHistoryRepository;
import com.husony.service.ReportRepairHistoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class ReportRepairHistoryServiceImpl implements ReportRepairHistoryService {
    @Autowired
    private ReportRepairHistoryRepository reportRepo;

    @Override
    public List<Reportrepairhistory> getReportRepairHistorys(Map<String, String> params) {
        return this.reportRepo.getReportRepairHistorys(params);
    }

    @Override
    public void addOrUpdate(Reportrepairhistory r) {
        this.reportRepo.addOrUpdate(r);
    }

    @Override
    public Reportrepairhistory getReportRepairHistoryById(long id) {
        return this.reportRepo.getReportRepairHistoryById(id);
    }

    @Override
    public void deleteReportRepairHistory(long id) {
        this.reportRepo.deleteReportRepairHistory(id);
    }
    
}
