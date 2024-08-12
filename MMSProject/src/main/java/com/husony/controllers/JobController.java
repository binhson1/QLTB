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
import com.husony.service.ScheduleRepairService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.inject.Instance;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private MaintenanceService maintenanceService;
    
    @Autowired
    private ScheduleRepairService repairService;
    

    @RequestMapping("/job")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("job", this.jobService.getJob());
        return "job";
    }

    @GetMapping("/job/add")
    public String createView(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("employees", this.employeeService.getEmployee());
        model.addAttribute("scheduleRepair", this.repairService.getScheduleRepair());
        model.addAttribute("maintenances", this.maintenanceService.getMaintenance());
        JobStatus[] statuses = JobStatus.values();
        model.addAttribute("status", statuses);
        return "addJob";
    }

    @PostMapping("/job/addOrUpdate")
    public String createView(Model model,
            @ModelAttribute(value = "job") @Valid Job j,
            BindingResult rs) {
        if (rs.hasErrors()) {
            System.err.println("Loi vai lzzzz");
            System.out.println(rs);
            return "addJob";
        }

        try {
            if ((j.getMaintenanceId() != null && j.getRepairId() == null)
                    || (j.getRepairId() != null && j.getMaintenanceId() == null)) {
                System.err.println("Helllloooooo");
                LocalDateTime date = LocalDateTime.now();
                LocalDateTime truncatedNow = date.truncatedTo(ChronoUnit.MINUTES);
                j.setUpdatedDate(truncatedNow);
                this.jobService.addOrUpdate(j);
            }
            else{
                model.addAttribute("errMsg", "Invalid");
                return "addJob";
            }
            return "redirect:/job";
        } catch (Exception ex) {
            System.err.println("Loi vai lzzzz");
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addJob";
    }
    
    @GetMapping("/job/{jobId}")
    public String updateView(Model model, @PathVariable(value = "jobId") long id) {
        model.addAttribute("job", this.jobService.getJobById(id));
        model.addAttribute("employees", this.employeeService.getEmployee());
        model.addAttribute("scheduleRepair", this.repairService.getScheduleRepair());
        model.addAttribute("maintenances", this.maintenanceService.getMaintenance());
        JobStatus[] statuses = JobStatus.values();
        model.addAttribute("status", statuses);
        return "addJob";
    }
}
