/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Employee;
import com.husony.repository.EmployeeRepository;
import com.husony.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeRepository employeeRepo;
    
    @Override
    public List<Employee> getEmployee() {
        return this.employeeRepo.getEmployee();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return this.employeeRepo.getEmployeeById(id);
    }

    @Override
    public void addOrUpdateEmployee(Employee e) {
        this.employeeRepo.addOrUpdateEmployee(e);
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepo.deleteEmployee(id);
    }
    
}
