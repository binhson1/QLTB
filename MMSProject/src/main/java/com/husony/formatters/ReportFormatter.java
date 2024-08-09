/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Report;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ACER
 */
public class ReportFormatter implements Formatter<Report> {
     @Override
    public String print(Report cate, Locale locale) {
        return String.valueOf(cate.getId());
    }

    @Override
    public Report parse(String reportId, Locale locale) throws ParseException {
        Report c = new Report();
        c.setId(Long.parseLong(reportId));
        
        return c;
    }
}
