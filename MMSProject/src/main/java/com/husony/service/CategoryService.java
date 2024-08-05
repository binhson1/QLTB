/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Devicecategory;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface CategoryService {
    List<Devicecategory> getCates();
    void addOrUpdateCate(Devicecategory c);
    Devicecategory getCateById(int id);
    void deleteCate(int id);
}
