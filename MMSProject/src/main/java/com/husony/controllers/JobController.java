/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Job;
import com.husony.pojo.JobStatus;
import com.husony.service.EmployeeService;
import com.husony.service.JobService;
import com.husony.service.MaintenanceService;
import com.husony.service.ReportService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private MaintenanceService maintenanceService;

    @RequestMapping("/job")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("job", this.jobService.getJob());

        return "job";
    }

    @GetMapping("/job/add")
    public String createView(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("employees", this.employeeService.getEmployee());
        model.addAttribute("reports", this.reportService.getReports());
        model.addAttribute("maintenances", this.maintenanceService.getMaintenance());
        JobStatus[] statuses = JobStatus.values();
        model.addAttribute("status", statuses);
        return "addJob";
    }
}
