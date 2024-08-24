/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.pojo.DeviceStatus;
import com.husony.pojo.Report;
import com.husony.service.DeviceService;
import com.husony.service.ReportService;
import com.husony.service.UserService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Do Gia Huy
 */
@RestController
@RequestMapping("/api")

public class ApiReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceService deviceService;

    @DeleteMapping("/report/delete/{reportId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin("http://localhost:8080/MMSApp")
    public void delete(@PathVariable(value = "reportId") long id) {
        this.reportService.deleteReport(id);
    }

    @PostMapping("/report/addOrUpdate")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<?> addOrUpdate(@RequestBody @Valid Report r, BindingResult rs) throws ParseException {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();            
        }
        Device d = this.deviceService.getDeviceById(r.getDeviceId().getId());
        d.setStatus(DeviceStatus.PENDING.toString());
        d.setFile(null);
        System.out.println(d.getStatus());
        this.reportService.addOrUpdate(r);
        this.deviceService.addOrUpdate(d);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/report")
    @CrossOrigin
    public ResponseEntity<List<Report>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.reportService.getReports(params), HttpStatus.OK);
    }
}
