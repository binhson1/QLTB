/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.service.DeviceService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    
    @GetMapping("/device/add")
    public String createView(Model model) {
        model.addAttribute("device", new Device());
        return "addDevice";
    }
    
    @PostMapping("/device/add")
    public String createView(Model model, 
            @ModelAttribute(value = "device") @Valid Device d,
            BindingResult rs) {
        if (rs.hasErrors())
            return "addDevice";
        
        try {
            //Check location history
            
            this.deviceService.addOrUpdate(d);
            
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "/";
    }
}
