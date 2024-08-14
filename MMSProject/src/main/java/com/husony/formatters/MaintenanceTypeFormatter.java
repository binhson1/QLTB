/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;


import com.husony.pojo.Maintenancetype;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class MaintenanceTypeFormatter implements Formatter<Maintenancetype> {
     @Override
    public String print(Maintenancetype maintenance, Locale locale) {
        return String.valueOf(maintenance.getId());
    }

    @Override
    public Maintenancetype parse(String maintenanceId, Locale locale) throws ParseException {
        Maintenancetype maintenance = new Maintenancetype();
        maintenance.setId(Long.parseLong(maintenanceId));
        
        return maintenance;
    }
}
