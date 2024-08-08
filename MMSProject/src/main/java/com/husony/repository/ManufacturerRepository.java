/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Manufacturer;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface ManufacturerRepository {
    List<Manufacturer> getManufac();
    void addOrUpdateManu(Manufacturer m);
    void deleteManu(long id);
    Manufacturer getManuById(long id);
}
