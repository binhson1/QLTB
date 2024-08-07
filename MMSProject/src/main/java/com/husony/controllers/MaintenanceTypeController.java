/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Maintenancetype;
import com.husony.service.MaintenanceTypeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class MaintenanceTypeController {
    
    @Autowired
    private MaintenanceTypeService maintenTypeService;
    
    @RequestMapping("/maintenancetype")
    public String maintenc(Model model){
        model.addAttribute("maintenancetyp", this.maintenTypeService.getMaintenanceType());
        return "maintenanceType";
    }        
    
    @GetMapping("/maintenancetype/add")
    public String createView(Model model){
        model.addAttribute("maintenancetype", new Maintenancetype());
        return "addMaintenanceType";
    }
    @PostMapping("/maintenancetype/add")
    public String createView(Model model, 
            @ModelAttribute(value = "maintenancetype") @Valid Maintenancetype m, 
            BindingResult rs){
        if (rs.hasErrors())
            return "addMaintenanceType";
        
        try {
            this.maintenTypeService.addOrUpdateMaintenanceType(m);
            
            return "redirect:/maintenanceType";            
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addMaintenanceType";
    }
    
}
