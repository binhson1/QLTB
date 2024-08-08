/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Report;
import com.husony.service.ReportService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;
    
    @RequestMapping("/report")
    public String reportIndex(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("reports", this.reportService.getReports());
        return "report";
    }
    
    @GetMapping("/report/add")
    public String createView(Model model) {
        model.addAttribute("report", new Report());
        return "addReport";
    }
}
