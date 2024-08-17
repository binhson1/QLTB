/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Job;
import com.husony.repository.JobRepository;
import com.husony.service.JobService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepo;

    @Override
    public List<Job> getJob(Map<String, String> params) {
        return this.jobRepo.getJob(params);
    }

    @Override
    public Job getJobById(long id) {
        return this.jobRepo.getJobById(id);
    }

    @Override
    public void deleteJob(long id) {
        this.jobRepo.deleteJob(id);
    }

    @Override
    public void addOrUpdate(Job j) {
        this.jobRepo.addOrUpdate(j);
    }
    
}
