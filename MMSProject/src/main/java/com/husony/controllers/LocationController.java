/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Location;
import com.husony.service.LocationHistoryService;
import com.husony.service.LocationService;
import java.util.Map;
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
public class LocationController {
    @Autowired
    private LocationService locationService;
    
    @Autowired
    private LocationHistoryService locationHistoryService;
    
    @RequestMapping("/location")
    public String location(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("location", this.locationService.getLocations());
        
        return "location";
    }
    
    @GetMapping("/location/add")
    public String createLocationView(Model model) {
        model.addAttribute("location", new Location());
        return "addLocation";
    }
    
    @PostMapping("/location/addOrUpdate")
    public String createLocationView(Model model,
            @ModelAttribute(value = "location") @Valid Location l,
            BindingResult rs) {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return "addLocation";
        }
        try {
            this.locationService.addOrUpdate(l);
            return "redirect:/location";
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
        }

        return "home";
    }
    
    @GetMapping("/location/{locationId}")
    public String detailsLocationView(Model model, @PathVariable(value = "locationId") long id) {
        model.addAttribute("location", this.locationService.getLocationById(id));
        return "addLocation";
    }
    
    @GetMapping("/location/{locationId}/device")
    public String locationdevices(Model model, @PathVariable(value="locationId") long id) {
        model.addAttribute("devices", this.locationHistoryService.getDevicesByLocation(id));
        return "home";
    }
}
