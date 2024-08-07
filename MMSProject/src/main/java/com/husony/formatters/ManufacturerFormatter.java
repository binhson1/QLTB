/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Manufacturer;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class ManufacturerFormatter implements Formatter<Manufacturer> {
    @Override
    public String print(Manufacturer manu, Locale locale) {
        return String.valueOf(manu.getId());
    }

    @Override
    public Manufacturer parse(String manuId, Locale locale) throws ParseException {
        Manufacturer m = new Manufacturer();
        m.setId(Long.parseLong(manuId));
        
        return m;
    }
}
