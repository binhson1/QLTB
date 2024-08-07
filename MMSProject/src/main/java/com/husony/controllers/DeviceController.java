/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.pojo.DeviceStatus;
import com.husony.pojo.Locationhistory;
import com.husony.service.CategoryService;
import com.husony.service.DeviceService;
import com.husony.service.LocationHistoryService;
import com.husony.service.LocationService;
import com.husony.service.ManufacturerService;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
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
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CategoryService cateService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationHistoryService locationHistoryService;

    @Autowired
    private ManufacturerService manuService;

    @GetMapping("/device/add")
    public String createView(Model model) {
        model.addAttribute("device", new Device());
        model.addAttribute("categories", this.cateService.getCates());
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("manus", this.manuService.getManufac());
        DeviceStatus[] statuses = DeviceStatus.values();
        model.addAttribute("status", statuses);
        return "addDevice";
    }

    @PostMapping("/device/addOrUpdate")
    public String createView(Model model,
            @ModelAttribute(value = "device") @Valid Device d,
            BindingResult rs) {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return "addDevice";
        }
        try {
            Date endDate = new Date();
            Boolean isUpdateLocation = false;
            Boolean isValid = false;
            if (d.getId() != null) {
                isValid = true;
                System.out.println("Helloowoenowneo");
                Device previousDevice = this.deviceService.getDeviceById(d.getId());
                Locationhistory l = this.locationHistoryService.getLocationByDevice(previousDevice);
                Locationhistory location = this.locationHistoryService.getLocationByDevice(d);
                if (!Objects.equals(l.getLocationId().getId(), d.getLocation().getId())) {
                    isUpdateLocation = true;
                    location.setActive(false);
                    location.setEndDate(endDate);
                    this.locationHistoryService.updateLocationDevice(location);
                }
            }
            System.out.println("Okkkk");
            this.deviceService.addOrUpdate(d);
            if ((isUpdateLocation == true && isValid == true) || isValid == false) {
                Locationhistory new_location = new Locationhistory();
                new_location.setDeviceId(d);
                new_location.setLocationId(d.getLocation());
                new_location.setBeginDate(endDate);
                new_location.setActive(true);
                this.locationHistoryService.createLocationDevice(new_location);
            }
            return "redirect:/";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "home";
    }

    @GetMapping("/device/{deviceId}")
    public String detailsView(Model model, @PathVariable(value = "deviceId") long id) {
        model.addAttribute("device", this.deviceService.getDeviceById(id));
        model.addAttribute("categories", this.cateService.getCates());
        model.addAttribute("locations", this.locationService.getLocations());
        model.addAttribute("manus", this.manuService.getManufac());
        DeviceStatus[] statuses = DeviceStatus.values();
        model.addAttribute("status", statuses);
        Device d = this.deviceService.getDeviceById(id);
        Locationhistory l = this.locationHistoryService.getLocationByDevice(d);
        model.addAttribute("deviceLocation", l.getLocationId());
        return "addDevice";
    }
}
