/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;
import com.husony.service.CategoryService;
import com.husony.service.DeviceService;
import com.husony.service.LocationHistoryService;
import com.husony.service.LocationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Do Gia Huy
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiDeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private CategoryService cateService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationHistoryService locationHistoryService;

    @GetMapping("/device")
    public ResponseEntity<List<Device>> list(@RequestParam Map<String, String> params) {
        List<Device> devices = this.deviceService.getDevices();

        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @PostMapping(path = "/device/addOrUpdate",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void addOrUpdate(@RequestParam Map<String, String> params, @RequestPart MultipartFile file) throws ParseException {

        Device d = new Device();
        if (params.get("id") != null) {
            System.out.println("noooooo");
            d.setId(Long.parseLong(params.get("id")));
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        d.setBoughtDate(formatter.parse(params.get("boughtDate")));
        if (file != null) {
            d.setFile(file);
        }
        d.setLocation(this.locationService.getLocationById(Long.parseLong(params.get("location"))));
        d.setDeviceCategoryId(this.cateService.getCateById(Long.parseLong(params.get("deviceCategoryId"))));
        d.setName(params.get("name"));
        d.setImage(params.get("image"));
        System.out.println(d);
        try {
            Date endDate = new Date();
            Boolean isUpdateLocation = false;
            Boolean isValid = false;
            if (d.getId() != null) {
                isValid = true;
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
            this.deviceService.addOrUpdate(d);
            if ((isUpdateLocation == true && isValid == true) || isValid == false) {
                Locationhistory new_location = new Locationhistory();
                new_location.setDeviceId(d);
                new_location.setLocationId(d.getLocation());
                new_location.setBeginDate(endDate);
                new_location.setActive(true);
                this.locationHistoryService.createLocationDevice(new_location);
            }
        } catch (Exception ex) {

        }
    }

    @DeleteMapping("/device/delete/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "deviceId") long id) {
        this.deviceService.deleteDevice(id);
    }
}
