/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Schedulerepair;
import com.husony.service.RepairTypeService;
import com.husony.service.ReportService;
import com.husony.service.ScheduleRepairService;
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

/**
 *
 * @author ACER
 */
@Controller
public class ScheduleRepairController {
    
    @Autowired
    private ScheduleRepairService scheduleRepairService;
    
    @Autowired
    private RepairTypeService repairTypeService;
    
    @Autowired
    private ReportService reportService;    
    
    @RequestMapping("/schedulerepair")
    public String index(Model model){
        model.addAttribute("schedulerepair", this.scheduleRepairService.getScheduleRepair());
        return "schedulerepair";
    }
    
    @GetMapping("/schedulerepair/add")
    public String createView(Model model) {
        model.addAttribute("schedulerepair", new Schedulerepair());
        model.addAttribute("repairtype", this.repairTypeService.getRepairType());
        model.addAttribute("report", this.reportService.getReports());
        return "addScheduleRepair";
    }
    
    @PostMapping("/schedulerepair/addOrUpdate")
    public String createView(Model model, 
            @ModelAttribute(value = "schedulerepair") @Valid Schedulerepair m,
            BindingResult rs) {
        if (rs.hasErrors())
            return "addScheduleRepair";
        
        try {
            this.scheduleRepairService.addOrUpdateScheduleRepair(m);
            
            return "redirect:/schedulerepair";            
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addScheduleRepair";
    }
    
    @GetMapping("/schedulerepair/{rId}")
    public String updateView(Model model, @PathVariable(value = "rId") long id) {
        model.addAttribute("schedulerepair", this.scheduleRepairService.getScheduleRepairById(id));
        return "addScheduleRepair";
    }
    
    
}
