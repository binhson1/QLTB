/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Device;
import com.husony.service.DeviceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin
public class ApiDeviceController {
    @Autowired
    private DeviceService deviceService;
    
    @GetMapping("/devices")
    public ResponseEntity<List<Device>> list(@RequestParam Map<String, String> params){
        List<Device> devices = this.deviceService.getDevices();
        
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }
    @DeleteMapping("/devices/delete/{deviceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "deviceId") long id) {
        this.deviceService.deleteDevice(id);
    }
}
