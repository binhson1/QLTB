/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.service.DeviceService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.husony.service.CategoryService;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class HomeController {
    @Autowired
    private DeviceService deviceService;
    
    
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        
        
        model.addAttribute("products", this.deviceService.getDevices());
        
        return "home";
    }
}
