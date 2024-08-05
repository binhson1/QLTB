/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Devicecategory;
import com.husony.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiCategoryController {
    @Autowired
    private CategoryService cateService;
    
    @GetMapping("/categories")
    public ResponseEntity<List<Devicecategory>> list() {
        return new ResponseEntity<>(this.cateService.getCates(), HttpStatus.OK);
    }
}
