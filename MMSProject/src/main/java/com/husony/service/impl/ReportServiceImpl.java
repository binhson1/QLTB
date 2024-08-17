/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Report;
import com.husony.repository.ReportRepository;
import com.husony.service.ReportService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepo;

    @Override
    public List<Report> getReports(Map<String, String> params) {
        return this.reportRepo.getReports(params);
    }

    @Override
    public void addOrUpdate(Report r) {
        this.reportRepo.addOrUpdate(r);
    }

    @Override
    public Report getReportById(long id) {
        return this.reportRepo.getReportById(id);
    }

    @Override
    public void deleteReport(long id) {
        this.reportRepo.deleteReport(id);
    }
    
}
