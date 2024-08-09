/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

/**
 *
 * @author Do Gia Huy
 */
public enum ReportStatus {
    PENDING(1),
    REPAIRED(2);
    
    private final int value;

    private ReportStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
