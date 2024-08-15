/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.pojo.DeviceMaintenance;
import com.husony.pojo.DeviceStatus;
import com.husony.pojo.Schedulemaintenance;
import com.husony.pojo.User;
import com.husony.service.DeviceService;
import com.husony.service.Device_MaintenanceService;
import com.husony.service.JobService;
import com.husony.service.MaintenanceService;
import com.husony.service.MaintenanceTypeService;
import com.husony.service.UserService;
import com.husony.service.impl.EmailServiceImpl;
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
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Do Gia Huy
 */
@Controller
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenanceTypeService maintenanceTypeService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private Device_MaintenanceService deviceMaintenanceService;

    @Autowired
    private JobService jobService;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private UserService userService;

    @RequestMapping("/maintenance")
    public String maintenance(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("maintenances", this.maintenanceService.getMaintenance(null));
//        Device d = this.deviceService.getDeviceById(1);
//        d.setStatus(DeviceStatus.PENDING.toString());
//        d.setFile(null);
//        this.deviceService.addOrUpdate(d);
        return "maintenance";
    }

    @GetMapping("/maintenance/add")
    public String createMaintenanceView(Model model) {
        model.addAttribute("maintenance", new Schedulemaintenance());
        model.addAttribute("maintenanceType", this.maintenanceTypeService.getMaintenanceType());
        model.addAttribute("devices", this.deviceService.getDevices(null));
        return "addMaintenance";
    }

    @PostMapping("/maintenance/addOrUpdate")
    public String createMaintenanceView(Model model,
            @ModelAttribute(value = "maintenance") @Valid Schedulemaintenance m,
            BindingResult rs) {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return "addMaintenance";
        }
        try {
            System.out.println("hello");
            this.maintenanceService.addOrUpdate(m);
            return "redirect:/maintenance";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "maintenance";
    }

    @GetMapping("/maintenance/{maintenanceId}/device")
    public String deviceMaintenanceView(Model model, @PathVariable(value = "maintenanceId") long id) {
        Map<String, String> params = new HashMap<>();
        params.put("scheduleMaintenanceId", String.valueOf(id));
        model.addAttribute("device_maintenance", this.deviceMaintenanceService.getDeviceMaintenance(params));
        model.addAttribute("scheduleMaintenanceId", String.valueOf(id));
        return "device_maintenance";
    }

    @GetMapping("/maintenance/{maintenanceId}/device/add")
    public String addDeviceMaintenanceView(Model model, @PathVariable(value = "maintenanceId") long id) {
        model.addAttribute("devices", this.deviceService.getDevices(null));
        model.addAttribute("scheduleMaintenance", this.maintenanceService.getMaintenanceById(id));
        model.addAttribute("deviceMaintenace", new DeviceMaintenance());
        return "addDeviceMaintenance";
    }

    @PostMapping("/maintenance/{maintenanceId}/device/add")
    public String addDeviceMaintenanceView(Model model,
            @ModelAttribute(value = "deviceMaintenace") @Valid DeviceMaintenance m,
            @PathVariable(value = "maintenanceId") long id,
            BindingResult rs) {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return "addDeviceMaintenance";
        }
        try {
            Long deviceId = m.getDeviceId().getId();
            Long scheduleMaintenanceId = m.getScheduleMaintenanceId().getId();
            DeviceMaintenance deviceMaintenace = this.deviceMaintenanceService
                    .getDeviceMaintenanceByDeviceAndMaintenance(deviceId, scheduleMaintenanceId);
            System.out.println(deviceMaintenace);
            if (deviceMaintenace != null) {
                model.addAttribute("errMsg", "INVALID");
                model.addAttribute("devices", this.deviceService.getDevices(null));
                model.addAttribute("scheduleMaintenance", this.maintenanceService.getMaintenanceById(id));
                model.addAttribute("deviceMaintenace", new DeviceMaintenance());
                return "addDeviceMaintenance";
            }
            this.deviceMaintenanceService.addOrUpdate(m);
            model.addAttribute("errMsg", "ADD SUCCESS");
            return "addDeviceMaintenance";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "addDeviceMaintenance";
    }

//    @Scheduled(fixedDelay = 10000)
//    public void scheduleNotifyEarly() {
//        try {
//            System.out.println("Start");
//            LocalDate today = LocalDate.now();
//            LocalDate tomorrow = today.plusDays(1);
//            Date date = Date.from(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant());
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String dateString = formatter.format(date);
//            Map<String, String> params = new HashMap<>();
//            params.put("nextMaintenanceDate", dateString);
//            List<Schedulemaintenance> scheduleMaintenance = this.maintenanceService.getMaintenance(params);
//
//            List<Schedulemaintenance> updateNextMaintenanceDateList = scheduleMaintenance.stream()
//                    .filter(m -> {
//                        if (m == null || m.getId() == null) {
//                            System.out.println("Saiiii");
//                            return false;
//                        }
//                        if (jobService.getJob() != null) {
//                            Boolean b = jobService.getJob().stream()
//                                    .filter(job -> job != null && job.getStartDate() != null && job.getMaintenanceId() != null)
//                                    .anyMatch(job -> {
//                                        LocalDateTime startDate = job.getStartDate();
//                                        // Kiểm tra null cho job.getMaintenanceId() và job.getMaintenanceId().getId()
//                                        return job.getMaintenanceId().getId() != null
//                                                && job.getMaintenanceId().getId().equals(m.getId())
//                                                && startDate.getYear() == tomorrow.getYear()
//                                                && startDate.getMonth() == tomorrow.getMonth();
//                                    });
//                            System.out.println(b);
//                            return b;
//                        }
//                        return false;
//                    }).collect(Collectors.toList());
//            System.out.println(updateNextMaintenanceDateList);
//            List<Schedulemaintenance> notifyList = scheduleMaintenance.stream()
//                    .filter(maintenance -> maintenance.getId() != null && !updateNextMaintenanceDateList.contains(maintenance.getId()))
//                    .collect(Collectors.toList());
//            System.out.println(notifyList);
//            updateNextMaintenanceDateList.stream().forEach(maintenance -> {
//                LocalDate updatedDate = tomorrow.plusMonths(maintenance.getIntervalMonth());
//                maintenance.setNextMaintenanceDate(Date.from(updatedDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//                this.maintenanceService.addOrUpdate(maintenance);
//            });
//            notifyList.stream().forEach(notify -> {
//                List<User> receivers = this.userService
//                        .getUsers().stream()
//                        .filter(user -> "ROLE_ADMIN".equals(user.getUserRole())
//                        || "ROLE_EMPLOYEE".equals(user.getUserRole()))
//                        .collect(Collectors.toList());
//                String[] to = receivers.stream()
//                        .map(User::getEmail)
//                        .toArray(String[]::new);
//                String subject = "REMINDER FOR " + notify.getName();
//                String text = "You haven't set job for " + notify.getName() + " " + notify.getNextMaintenanceDate();
//                System.out.println(Arrays.toString(to));
//                System.out.println(subject);
//                System.out.println(text);
//                emailService.sendSimpleMessage(to, subject, text);
//            });
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleNotifyLate() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(yesterday);
        Map<String, String> params = new HashMap<>();
        params.put("nextMaintenanceDate", dateString);
        List<Schedulemaintenance> scheduleMaintenance = this.maintenanceService.getMaintenance(params);
        List<Schedulemaintenance> notifyList = scheduleMaintenance.stream()
                .filter(maintenance -> {
                    return jobService.getJob().stream()
                            .anyMatch(job -> {
                                LocalDateTime startDate = job.getStartDate();
                                return Objects.equals(job.getMaintenanceId().getId(), maintenance.getId())
                                        && startDate.getYear() == yesterday.getYear()
                                        && startDate.getMonth() != yesterday.getMonth();
                            });
                })
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
            String text = "You haven't set job for " + notify.getName() + " " + notify.getNextMaintenanceDate();
            emailService.sendSimpleMessage(to, subject, text);
            LocalDate updatedDate = yesterday.plusMonths(notify.getIntervalMonth());
            notify.setNextMaintenanceDate(Date.from(updatedDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            this.maintenanceService.addOrUpdate(notify);
        });
    }
}
