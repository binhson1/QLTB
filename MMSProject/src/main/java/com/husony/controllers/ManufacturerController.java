/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Manufacturer;
import com.husony.service.DeviceService;
import com.husony.service.ManufacturerService;
import java.util.HashMap;
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

/**
 *
 * @author ACER
 */
@Controller
public class ManufacturerController {
    
    @Autowired
    private ManufacturerService manuService;
    
    @Autowired
    private DeviceService deviceService;
    
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
    public String manu(Model model, Map<String, String> params){        
        
        model.addAttribute("manu", this.manuService.getManufac(params));
        
        return "manufacturer";
    }
    
    @GetMapping("/manufacturer/{mId}/device")
    public String deviceOfManufacturer(Model model, @PathVariable("mId") long id){
        Map<String, String> params = new HashMap<>();
        params.put("manuId", String.valueOf(id));
        model.addAttribute("devices", this.deviceService.getDevices(params));
        return "home";
    }
}
