/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Schedulerepair;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface ScheduleRepairService {
    List<Schedulerepair> getScheduleRepair(Map<String, String> params);
    Schedulerepair getScheduleRepairById(long id);
    void deleteScheduleRepair(long id);
    void addOrUpdateScheduleRepair(Schedulerepair r);
}
