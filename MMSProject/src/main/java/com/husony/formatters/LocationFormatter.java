/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Location;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class LocationFormatter implements Formatter<Location> {
    @Override
    public String print(Location loca, Locale locale) {
        return String.valueOf(loca.getId());
    }

    @Override
    public Location parse(String locaId, Locale locale) throws ParseException {
        Location l = new Location();
        l.setId(Long.parseLong(locaId));
        
        return l;
    }
}
