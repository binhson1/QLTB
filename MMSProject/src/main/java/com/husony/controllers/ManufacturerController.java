/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class ManufacturerController {
    
    @Autowired
    private ManufacturerService manuService;
    @RequestMapping("/manufacturer")
    public String manu(Model model){        
        model.addAttribute("manu", this.manuService.getManufac());
        return "manufacturer";
    }
}
