/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.husony.pojo.Device;
import com.husony.repository.DeviceRepository;
import com.husony.service.DeviceService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepo;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Device> getDevices() {
        return this.deviceRepo.getDevices();
    }

    @Override
    public void addOrUpdate(Device d) {
         if (!d.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(d.getFile().getBytes(),
                            ObjectUtils.asMap("resource_type", "auto"));
                
                d.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(DeviceServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.deviceRepo.addOrUpdate(d);
    }

    @Override
    public Device getDeviceById(long id) {
        return this.deviceRepo.getDeviceById(id);
    }
    
}
