/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Schedulerepair;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ScheduleRepairService {
    List<Schedulerepair> getScheduleRepair();
    Schedulerepair getScheduleRepairById(long id);
    void deleteScheduleRepair(long id);
    void addOrUpdateScheduleRepair(Schedulerepair r);
}
