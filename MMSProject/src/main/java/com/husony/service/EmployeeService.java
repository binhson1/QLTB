/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Employee;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface EmployeeService {
    List<Employee> getEmployee(Map<String, String> params);
    Employee getEmployeeById(long id);
    void addOrUpdateEmployee(Employee e);
    void deleteEmployee(long id);
}
