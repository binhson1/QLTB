/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Device;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class DeviceFormatter implements Formatter<Device> {

    @Override
    public String print(Device device, Locale locale) {
        return String.valueOf(device.getId());
    }

    @Override
    public Device parse(String deviceId, Locale locale) throws ParseException {
        Device d = new Device();
        d.setId(Long.parseLong(deviceId));
        
        return d;
    }
    
}
