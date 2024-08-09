/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Employee;
import com.husony.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
public class ApiEmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @DeleteMapping("/employee/delete/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "employeeId") long id){
        this.employeeService.deleteEmployee(id);
    }
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> list(){
        return new ResponseEntity<>(this.employeeService.getEmployee(), HttpStatus.OK);
    }
}
