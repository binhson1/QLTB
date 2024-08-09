/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Report;
import com.husony.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Do Gia Huy
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiReportController {
    @Autowired
    private ReportService reportService;
    
    @DeleteMapping("/report/delete/{reportId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "reportId") long id){
        this.reportService.deleteReport(id);
    }
    
    @GetMapping("/report")
    public ResponseEntity<List<Report>> list(){
        return new ResponseEntity<>(this.reportService.getReports(), HttpStatus.OK);
    }
}
