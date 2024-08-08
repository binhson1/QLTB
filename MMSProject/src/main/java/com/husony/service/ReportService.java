/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Report;
import java.util.List;

/**
 *
 * @author Do Gia Huy
 */
public interface ReportService {
    List<Report> getReports();
    void addOrUpdate(Report r);
    Report getReportById(long id);
    void deleteReport(long id);
}
