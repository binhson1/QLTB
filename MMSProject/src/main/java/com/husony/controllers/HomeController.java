/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Schedulemaintenance;
import com.husony.pojo.Schedulerepair;
import com.husony.service.DeviceService;
import com.husony.service.MaintenanceService;
import com.husony.service.ScheduleRepairService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class HomeController {

    @Autowired
    private DeviceService deviceService;
    
    @Autowired
    private ScheduleRepairService scheduleRepairService;
    
    @Autowired
    private MaintenanceService scheduleMaintenanceService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        Date date = Date.from(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        Map<String, String> p1 = new HashMap<>();
        p1.put("date", dateString);
        Map<String, String> p2 = new HashMap<>();
        p2.put("nextMaintenanceDate", dateString);
        List<Schedulerepair> scheduleRepair = this.scheduleRepairService.getScheduleRepair(p1);
        List<Schedulemaintenance> scheduleMaintenance = this.scheduleMaintenanceService.getMaintenance(p2);
        System.out.println(scheduleRepair);
        System.out.println(scheduleMaintenance);
        model.addAttribute("scheduleRepair", scheduleRepair);
        model.addAttribute("scheduleMaintenance", scheduleMaintenance);
        model.addAttribute("devices", this.deviceService.getDevices(params));
        return "home";
    }
}
