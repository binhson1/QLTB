/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Repairtype;
import com.husony.service.RepairTypeService;
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
public class RepairTypeController {
    
    @Autowired
    private RepairTypeService repairTypeService;
    
    @RequestMapping("/repairtype")
    public String Repairtype(Model model){
        model.addAttribute("repairtype", repairTypeService.getRepairType());
        return "repairType";
    }
    
    @GetMapping("/repairtype/add")
    public String createView(Model model) {
        model.addAttribute("repairtype", new Repairtype());
        return "addRepairType";
    }
    
    @PostMapping("/repairtype/addOrUpdate")
    public String createView(Model model, 
            @ModelAttribute(value = "repairtype") @Valid Repairtype m,
            BindingResult rs) {
        if (rs.hasErrors())
            return "addRepairType";
        
        try {
            this.repairTypeService.addOrUpdateRepairType(m);
            
            return "redirect:/repairType";            
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addRepairType";
    }
    
    @GetMapping("/repairtype/{rId}")
    public String updateView(Model model, @PathVariable(value = "rId") long id) {
        model.addAttribute("repairtype", this.repairTypeService.getRepairTypeById(id));
        return "addRepairType";
    }
    
}
