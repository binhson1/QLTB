/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Reportrepairhistory;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */

public interface ReportRepairHistoryService {
     List<Reportrepairhistory> getReportRepairHistorys(Map<String, String> params);
    void addOrUpdate(Reportrepairhistory r);
    Reportrepairhistory getReportRepairHistoryById(long id);
    void deleteReportRepairHistory(long id);
}
