/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Schedulerepair;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class RepairFormatter implements Formatter<Schedulerepair> {
    @Override
    public String print(Schedulerepair repair, Locale locale) {
        return String.valueOf(repair.getId());
    }

    @Override
    public Schedulerepair parse(String repairId, Locale locale) throws ParseException {
        Schedulerepair r = new Schedulerepair();
        r.setId(Long.parseLong(repairId));
        
        return r;
    }
}
