/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Maintenancetype;
import com.husony.service.MaintenanceTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiMaintenanceTypeController {
    @Autowired
    private MaintenanceTypeService maintenService;
    
    @DeleteMapping("/maintenancetype/delete/{maintenancetypeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "maintenancetypeId") int id) {
        this.maintenService.deleteMaintenanceType(id);
    }
    
    @GetMapping("/maintenancetypes")
    public ResponseEntity<List<Maintenancetype>> list() {
        return new ResponseEntity<>(this.maintenService.getMaintenanceType(), HttpStatus.OK);
    }
}
