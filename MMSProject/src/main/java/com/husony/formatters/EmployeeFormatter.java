/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Employee;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class EmployeeFormatter implements Formatter<Employee> {

    @Override
    public String print(Employee employee, Locale locale) {
        return String.valueOf(employee.getId());
    }

    @Override
    public Employee parse(String employeeId, Locale locale) throws ParseException {
        Employee e = new Employee();
        e.setId(Long.parseLong(employeeId));
        
        return e;
    }
    
}
