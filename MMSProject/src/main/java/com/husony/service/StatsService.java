/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import java.util.List;

/**
 *
 * @author ACER
 */
public interface StatsService {
    public List<Object[]> statsRevenueByDevice();
    public List<Object[]> statsDeviceByCategory();
    public List<Object[]> statsDeviceByStatus();
    public List<Object[]> statsRepairCostDevice(int year, String period);
}
