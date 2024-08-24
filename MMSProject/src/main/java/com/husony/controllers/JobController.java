/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.pojo.DeviceMaintenance;
import com.husony.pojo.DeviceStatus;
import com.husony.pojo.Job;
import com.husony.pojo.JobStatus;
import com.husony.pojo.Report;
import com.husony.pojo.ReportStatus;
import com.husony.pojo.Schedulemaintenance;
import com.husony.pojo.Schedulerepair;
import com.husony.service.DeviceService;
import com.husony.service.Device_MaintenanceService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private Device_MaintenanceService deviceMaintenanceService;

    @Autowired
    private ReportService reportService;

    @RequestMapping("/job")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("job", this.jobService.getJob(params));
        return "job";
    }

    @GetMapping("/job/add")
    public String createView(Model model) {
        model.addAttribute("job", new Job());
        model.addAttribute("employees", this.employeeService.getEmployee(null));
        model.addAttribute("scheduleRepair", this.repairService.getScheduleRepair(null));
        model.addAttribute("maintenances", this.maintenanceService.getMaintenance(null));
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
                
                if (!j.getStatus().equals(JobStatus.PENDING.toString())) {
                    //Truong hop la lich bao tri
                    if (j.getMaintenanceId() != null) {
                        System.out.println("1111");
                        Schedulemaintenance maintenance = maintenanceService.getMaintenanceById(j.getMaintenanceId().getId());
                        Map<String, String> params = new HashMap<>();
                        params.put("scheduleMaintenanceId", String.valueOf(maintenance.getId()));
                        List<Device> devices = this.deviceMaintenanceService.getDeviceMaintenance(params).stream()
                                .map(m -> m.getDeviceId())
                                .collect(Collectors.toList());
                        
                        // Cap nhat trang thai device sang active, ngay bao tri cuoi cung cua lich bao tri
                        devices.stream().forEach(d -> {
                            if (j.getStatus().equals(JobStatus.DONE.toString())) {
                                d.setStatus(DeviceStatus.ACTIVE.toString());
                                LocalDate today = LocalDate.now();
                                Date last_date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
                                maintenance.setLastMaintenanceDate(last_date);
                                this.maintenanceService.addOrUpdate(maintenance);
                            } else if (j.getStatus().equals(JobStatus.PROCCESSED.toString())) {
                                d.setStatus(DeviceStatus.MAINTENANCE.toString());
                            }
                            d.setFile(null);
                            this.deviceService.addOrUpdate(d);
                        });
                        
                        // Truong hop la lich sua chua 
                    } else if (j.getRepairId() != null) {
                        System.out.println("2222");
                        Schedulerepair repair = this.repairService.getScheduleRepairById(j.getRepairId().getId());
                        Report report = repair.getReportId();
                        Device d = report.getDeviceId();
                        // neu cong viec hoan thanh => cap nhat trang thai report thanh repaired, 
                        // device thanh active
                        if (j.getStatus().equals(JobStatus.DONE.toString())) {
                            report.setStatus(ReportStatus.REPAIRED.toString());
                            d.setStatus(DeviceStatus.ACTIVE.toString());
                            // Neu cong viec trang thai dang tien hanh
                            // Cap nhat trang thai report dang tien hanh
                            // device thanh repair
                        } else if (j.getStatus().equals(JobStatus.PROCCESSED.toString())) {
                            report.setStatus(ReportStatus.PROCESS.toString());
                            d.setStatus(DeviceStatus.REPAIR.toString());
                        }
                        d.setFile(null);
                        this.reportService.addOrUpdate(report);
                        this.deviceService.addOrUpdate(d);
                    }
                }

                this.jobService.addOrUpdate(j);
            } else {
                model.addAttribute("errMsg", "Invalid");
                return "addJob";
            }
            return "redirect:/job";
        } catch (Exception ex) {
            System.out.println(ex);
            System.err.println("Loi vai 2222");
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addJob";
    }

    @GetMapping("/job/{jobId}")
    public String updateView(Model model, @PathVariable(value = "jobId") long id) {
        model.addAttribute("job", this.jobService.getJobById(id));
        model.addAttribute("employees", this.employeeService.getEmployee(null));
        model.addAttribute("scheduleRepair", this.repairService.getScheduleRepair(null));
        model.addAttribute("maintenances", this.maintenanceService.getMaintenance(null));
        JobStatus[] statuses = JobStatus.values();
        model.addAttribute("status", statuses);
        return "addJob";
    }
}
