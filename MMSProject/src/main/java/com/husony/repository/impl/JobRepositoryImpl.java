/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Job;
import com.husony.repository.JobRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Do Gia Huy
 */
@Repository
@Transactional
public class JobRepositoryImpl implements JobRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Job> getJob() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Job");
        return q.getResultList();
    }

    @Override
    public Job getJobById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Job.class, id);
    }

    @Override
    public void deleteJob(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getJobById(id));
    }

    @Override
    public void addOrUpdate(Job j) {
        Session s = this.factory.getObject().getCurrentSession();
        if (j.getId() != null) {
            s.update(j);
        } else {
            s.save(j);
        }
    }
    
}
