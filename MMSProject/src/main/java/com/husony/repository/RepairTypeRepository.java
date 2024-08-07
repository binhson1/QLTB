/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Repairtype;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface RepairTypeRepository {
    List<Repairtype> getRepairType();
    Repairtype getRepairTypeById(int id);
    void addOrUpdateRepairType(Repairtype r);
    void deleteRepairType(int id);
}
