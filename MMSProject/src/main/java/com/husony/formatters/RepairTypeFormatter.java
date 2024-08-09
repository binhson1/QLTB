/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Repairtype;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class RepairTypeFormatter implements Formatter<Repairtype> {

    @Override
    public String print(Repairtype cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override
    public Repairtype parse(String repairTypeId, Locale locale) throws ParseException {
        Repairtype c = new Repairtype();
        c.setId(Long.parseLong(repairTypeId));
        return c;
    }
}
