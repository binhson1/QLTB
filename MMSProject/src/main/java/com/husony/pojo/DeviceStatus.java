/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.husony.pojo;

/**
 *
 * @author Do Gia Huy
 */
public enum DeviceStatus {
    ACTIVE(1),
    MAINTENANCE(2),
    REPAIR(3);
    
    private final int value;

    private DeviceStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
