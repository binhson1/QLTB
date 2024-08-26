/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class StatsController {
    
    @Autowired
    private StatsService statsService;
    
    @RequestMapping("/stats")
    public String deviceStats(Model model){
        model.addAttribute("stats", this.statsService.statsRevenueByDevice());
        model.addAttribute("statsDeviceByCate", this.statsService.statsDeviceByCategory());
        model.addAttribute("statsDeviceByStatus", this.statsService.statsDeviceByStatus());
        model.addAttribute("statsRepairCostDevice", this.statsService.statsRepairCostDevice());
        return "stats";
    }
}
