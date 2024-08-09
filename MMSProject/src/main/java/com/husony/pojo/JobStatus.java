/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.husony.pojo;

/**
 *
 * @author Do Gia Huy
 */
public enum JobStatus {
    PENDING(1),
    PROCCESSED(2),
    DONE(3);
    
    private final int value;

    private JobStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
