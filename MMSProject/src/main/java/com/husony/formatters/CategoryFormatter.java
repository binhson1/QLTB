/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Devicecategory;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class CategoryFormatter implements Formatter<Devicecategory> {
    @Override
    public String print(Devicecategory cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override
    public Devicecategory parse(String cateId, Locale locale) throws ParseException {
        Devicecategory c = new Devicecategory();
        c.setId(Long.parseLong(cateId));
        
        return c;
    }
}
