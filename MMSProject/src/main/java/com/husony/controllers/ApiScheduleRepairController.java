/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Schedulerepair;
import com.husony.service.ScheduleRepairService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiScheduleRepairController {

    @Autowired
    private ScheduleRepairService scheduleRepairService;
    
    @CrossOrigin("http://localhost:8080/MMSApp")
    @DeleteMapping("/schedulerepair/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {
        this.scheduleRepairService.deleteScheduleRepair(id);
    }
    
    @CrossOrigin
    @PostMapping("/schedulerepair/addOrUpdate/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addOrUpdate(@RequestBody @Valid Schedulerepair r, BindingResult rs) throws ParseException {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();            
        }
        this.scheduleRepairService.addOrUpdateScheduleRepair(r);
        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }
    
    @GetMapping("/schedulerepair")
    public ResponseEntity<List<Schedulerepair>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.scheduleRepairService.getScheduleRepair(null), HttpStatus.OK);
    }
    
}
