/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Repairtype;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface RepairTypeService {
    List<Repairtype> getRepairType();
    Repairtype getRepairTypeById(long id);
    void addOrUpdateRepairType(Repairtype r);
    void deleteRepairType(long id);
}
