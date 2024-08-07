/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Devicecategory;
import com.husony.service.CategoryService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class CategoryController {
    
    @Autowired
    private CategoryService cateService;
    
    @RequestMapping("/category")
    public String cate(Model model){
        model.addAttribute("cates", this.cateService.getCates());
        return "category";
    }            

    @GetMapping("/category/add")
    public String createView(Model model) {
        
        model.addAttribute("category", new Devicecategory());
        return "addCate";
    }
    
    @PostMapping("/category/addOrUpdate")
    public String createView(Model model, 
            @ModelAttribute(value = "category") @Valid Devicecategory c,
            BindingResult rs) {
        if (rs.hasErrors())
            return "addCate";
        
        try {
            this.cateService.addOrUpdateCate(c);
            
            return "redirect:/category";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }
        
        return "addCate";
    }
    
    @GetMapping("/categories/{categoryId}")
    public String updateView(Model model, @PathVariable(value = "categoryId") long id) {
        model.addAttribute("category", this.cateService.getCateById(id));
        return "addCate";
    }
    
    
}
