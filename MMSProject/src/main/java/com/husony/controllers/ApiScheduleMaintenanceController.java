/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Schedulemaintenance;
import com.husony.pojo.Schedulerepair;
import com.husony.service.MaintenanceService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
@RestController
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
    
    @PostMapping("/maintenance/delete/{id}")
    @CrossOrigin("http://localhost:8080/MMSApp")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void delete(@PathVariable(value = "id") long id) {
        this.maintenService.deleteMaintenance(id);
    }
}
