/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Report;
import com.husony.pojo.Schedulemaintenance;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class MaintenanceFormatter implements Formatter<Schedulemaintenance> {
     @Override
    public String print(Schedulemaintenance maintenance, Locale locale) {
        return String.valueOf(maintenance.getId());
    }

    @Override
    public Schedulemaintenance parse(String maintenanceId, Locale locale) throws ParseException {
        Schedulemaintenance maintenance = new Schedulemaintenance();
        maintenance.setId(Long.parseLong(maintenanceId));
        
        return maintenance;
    }
}
