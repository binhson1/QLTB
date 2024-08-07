/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Employee;
import com.husony.service.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("/employee")
    public String employee(Model model){
        
        model.addAttribute("employee", this.employeeService.getEmployee());
        return "employee";
    }
    
    @GetMapping("/employee/add")
    public String createView(Model model) {
        
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }
    
    @PostMapping("/employee/add")
    public String createView(Model model, 
            @ModelAttribute(value = "employee") @Valid Employee c,
            BindingResult rs) {
        if (rs.hasErrors())
            return "addEmployee";
        
        try {
            this.employeeService.addOrUpdateEmployee(c);
            
            return "redirect:/employee";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addEmployee";
    }
}

