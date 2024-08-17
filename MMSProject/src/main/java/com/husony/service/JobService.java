/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Job;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */
public interface JobService {
    List<Job> getJob(Map<String, String> params);
    Job getJobById(long id);
    void deleteJob(long id);
    void addOrUpdate(Job j);
}
