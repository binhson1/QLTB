/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Schedulemaintenance;
import com.husony.pojo.Schedulerepair;
import com.husony.pojo.User;
import com.husony.service.JobService;
import com.husony.service.RepairTypeService;
import com.husony.service.ReportService;
import com.husony.service.ScheduleRepairService;
import com.husony.service.UserService;
import com.husony.service.impl.EmailServiceImpl;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
public class ScheduleRepairController {

    @Autowired
    private ScheduleRepairService scheduleRepairService;

    @Autowired
    private RepairTypeService repairTypeService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private JobService jobService;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private UserService userService;

    @RequestMapping("/schedulerepair")
    public String index(Model model) {
        model.addAttribute("schedulerepair", this.scheduleRepairService.getScheduleRepair(null));
        return "schedulerepair";
    }

    @GetMapping("/schedulerepair/add")
    public String createView(Model model) {
        model.addAttribute("schedulerepair", new Schedulerepair());
        model.addAttribute("repairtype", this.repairTypeService.getRepairType());
        model.addAttribute("report", this.reportService.getReports(null));
        return "addScheduleRepair";
    }

    @PostMapping("/schedulerepair/addOrUpdate")
    public String createView(Model model,
            @ModelAttribute(value = "schedulerepair") @Valid Schedulerepair m,
            BindingResult rs) {
        if (rs.hasErrors()) {
            return "addScheduleRepair";
        }

        try {
            this.scheduleRepairService.addOrUpdateScheduleRepair(m);

            return "redirect:/schedulerepair";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addScheduleRepair";
    }

    @GetMapping("/schedulerepair/{rId}")
    public String updateView(Model model, @PathVariable(value = "rId") long id) {
        model.addAttribute("schedulerepair", this.scheduleRepairService.getScheduleRepairById(id));
        model.addAttribute("repairtype", this.repairTypeService.getRepairType());
        model.addAttribute("report", this.reportService.getReports(null));
        return "addScheduleRepair";
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleNotifyEarly() {
        try {
            System.out.println("Start");
            LocalDate today = LocalDate.now();
            LocalDate tomorrow = today.plusDays(1);
            Date date = Date.from(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            Map<String, String> params = new HashMap<>();
            params.put("date", dateString);
            List<Schedulerepair> scheduleRepair = this.scheduleRepairService.getScheduleRepair(params);

            List<Schedulerepair> non_notify = scheduleRepair.stream()
                    .filter(r -> {
                        if (r == null || r.getId() == null) {
                            System.out.println("Saiiii");
                            return false;
                        }
                        if (jobService.getJob(null) != null) {
                            Boolean b = jobService.getJob(null).stream()
                                    .filter(job -> job != null && job.getStartDate() != null && job.getRepairId() != null)
                                    .anyMatch(job -> {
                                        LocalDateTime startDate = job.getStartDate();
                                        return job.getRepairId().getId() != null
                                                && job.getRepairId().getId().equals(r.getId())
                                                && startDate.getYear() == tomorrow.getYear()
                                                && startDate.getMonth() == tomorrow.getMonth();
                                    });
                            return b;
                        }
                        return false;
                    }).collect(Collectors.toList());
            System.out.println(non_notify);
            List<Schedulerepair> notifyList = scheduleRepair.stream()
                    .filter(repair -> repair.getId() != null && !non_notify.contains(repair.getId()))
                    .collect(Collectors.toList());
            System.out.println(notifyList);
            notifyList.stream().forEach(notify -> {
                List<User> receivers = this.userService
                        .getUsers().stream()
                        .filter(user -> "ROLE_ADMIN".equals(user.getUserRole())
                        || "ROLE_EMPLOYEE".equals(user.getUserRole()))
                        .collect(Collectors.toList());
                String[] to = receivers.stream()
                        .map(User::getEmail)
                        .toArray(String[]::new);
                String subject = "REMINDER FOR " + notify.getName();
                String text = "You haven't set job for " + notify.getName() + " " + notify.getDate();
                System.out.println(Arrays.toString(to));
                System.out.println(subject);
                System.out.println(text);
                try {
                    emailService.sendSimpleMessage(to, subject, text);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ScheduleRepairController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleNotifyLate() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        Date date = Date.from(yesterday.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        Map<String, String> params = new HashMap<>();
        params.put("date", dateString);
        List<Schedulerepair> scheduleRepair = this.scheduleRepairService.getScheduleRepair(params);
        List<Schedulerepair> non_notifyList = scheduleRepair.stream()
                .filter(r -> {
                    Boolean b = jobService.getJob(null).stream()
                            .anyMatch(job -> {
                                LocalDateTime startDate = job.getStartDate();
                                return Objects.equals(job.getRepairId().getId(), r.getId())
                                        && startDate.getYear() == yesterday.getYear()
                                        && startDate.getMonth() == yesterday.getMonth();
                            });
                    return b;
                })
                .collect(Collectors.toList());
        List<Schedulerepair> notifyList = scheduleRepair.stream()
                .filter(r -> r.getId() != null && !non_notifyList.contains(r.getId()))
                .collect(Collectors.toList());
        notifyList.stream().forEach(notify -> {
            List<User> receivers = this.userService
                    .getUsers().stream()
                    .filter(user -> "ROLE_ADMIN".equals(user.getUserRole())
                    || "ROLE_EMPLOYEE".equals(user.getUserRole()))
                    .collect(Collectors.toList());
            String[] to = receivers.stream()
                    .map(User::getEmail)
                    .toArray(String[]::new);
            String subject = "REMINDER FOR " + notify.getName();
            String text = "You haven't set job for " + notify.getName() + " " + notify.getDate();
            try {
                emailService.sendSimpleMessage(to, subject, text);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ScheduleRepairController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
