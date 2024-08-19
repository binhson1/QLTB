/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Schedulemaintenance;
import com.husony.service.MaintenanceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiScheduleMaintenanceController {
    @Autowired
    private MaintenanceService maintenService;
    
    @RequestMapping("/maintenances")
    public ResponseEntity<List<Schedulemaintenance>> maintenance() {
        return new ResponseEntity<>(this.maintenService.getMaintenance(null), HttpStatus.OK);        
    }
    
    @RequestMapping("/maintenances/{id}")
    public ResponseEntity<Schedulemaintenance> getMaintenanceById(@PathVariable(value = "id")long id){
        return new ResponseEntity<>(this.maintenService.getMaintenanceById(id), HttpStatus.OK);
    }
}
