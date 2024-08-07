/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Employee;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface EmployeeService {
    List<Employee> getEmployee();
    Employee getEmployeeById(int id);
    void addOrUpdateEmployee(Employee e);
    void deleteEmployee(int id);
}
