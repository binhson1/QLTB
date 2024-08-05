/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Devicecategory;
import com.husony.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.husony.service.CategoryService;

/**
 *
 * @author ACER
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository cateRepo;
    
    @Override
    public List<Devicecategory> getCates() {
        return this.cateRepo.getCates();
    }

    @Override
    public void addOrUpdateCate(Devicecategory c) {
        this.cateRepo.addOrUpdateCate(c);
    }

    @Override
    public Devicecategory getCateById(int id) {
        return this.cateRepo.getCateById(id);
    }

    @Override
    public void deleteCate(int id) {
        this.cateRepo.deleteCate(id);
    }
    
}
