/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.Job;
import java.util.List;

/**
 *
 * @author Do Gia Huy
 */
public interface JobRepository {
    List<Job> getJob();
    Job getJobById(long id);
    void deleteJob(long id);
    void addOrUpdate(Job j);
}
