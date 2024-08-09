/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Report;
import com.husony.pojo.ReportStatus;
import com.husony.service.DeviceService;
import com.husony.service.ReportService;
import com.husony.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class ReportController {
    @Autowired
    private DeviceService deviceService;
    
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/report")
    public String reportIndex(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("reports", this.reportService.getReports());
        return "report";
    }
    
    @GetMapping("/report/add")
    public String createView(Model model) {
        model.addAttribute("report", new Report());
        model.addAttribute("devices", this.deviceService.getDevices());
        model.addAttribute("users", this.userService.getUsers());
        ReportStatus[] statuses = ReportStatus.values();
        model.addAttribute("status", statuses);
        return "addReport";
    }
    @PostMapping("/report/addOrUpdate")
    public String createView(Model model, 
            @ModelAttribute(value = "report") @Valid Report r,
            BindingResult rs) {
        if (rs.hasErrors()){
            System.out.println(rs);
            return "addReport";
        }
        
        try {
            this.reportService.addOrUpdate(r);
            
            return "redirect:/report";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addReport";
    }
    @GetMapping("/report/{reportId}")
    public String updateView(Model model, @PathVariable(value = "reportId") long id) {
        model.addAttribute("report", this.reportService.getReportById(id));
        model.addAttribute("devices", this.deviceService.getDevices());
        model.addAttribute("users", this.userService.getUsers());
        ReportStatus[] statuses = ReportStatus.values();
        model.addAttribute("status", statuses);
        return "addReport";
    }
}
