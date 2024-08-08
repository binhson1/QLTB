/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Manufacturer;
import com.husony.service.ManufacturerService;
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
public class ManufacturerController {
    
    @Autowired
    private ManufacturerService manuService;
    
    @GetMapping("/manufacturer/add")
    public String createView(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "addManu";
    }
    
    @PostMapping("/manufacturer/addOrUpdate")
    public String createView(Model model, 
            @ModelAttribute(value = "manufacturer") @Valid Manufacturer m,
            BindingResult rs) {
        if (rs.hasErrors())
            return "addManu";
        
        try {
            this.manuService.addOrUpdateManu(m);
            
            return "redirect:/manufacturer";            
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addManu";
    }
    
    @GetMapping("/manufacturer/{mId}")
    public String updateView(Model model, @PathVariable("mId") long id){
        model.addAttribute("manufacturer", this.manuService.getManuById(id));
        return "addManu";
    }
    
    @RequestMapping("/manufacturer")
    public String manu(Model model){        
        
        model.addAttribute("manu", this.manuService.getManufac());
        
        return "manufacturer";
    }
}
