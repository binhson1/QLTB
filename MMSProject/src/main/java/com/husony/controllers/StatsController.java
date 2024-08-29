/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.service.StatsService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
public class StatsController {

    @Autowired
    private StatsService statsService;

    @RequestMapping("/stats")
    public String deviceStats(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("stats", this.statsService.statsRevenueByDevice());
        model.addAttribute("statsDeviceByCate", this.statsService.statsDeviceByCategory());
        model.addAttribute("statsDeviceByStatus", this.statsService.statsDeviceByStatus());
        String year = params.getOrDefault("year", String.valueOf(LocalDate.now().getYear()));
        String period = params.getOrDefault("period", "MONTH");
        model.addAttribute("statsRepairCostDevice", this.statsService.statsRepairCostDevice(Integer.parseInt(year), period));
        return "stats";
    }
}
