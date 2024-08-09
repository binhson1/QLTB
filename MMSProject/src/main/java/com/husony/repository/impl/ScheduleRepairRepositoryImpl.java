/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Schedulerepair;
import com.husony.repository.ScheduleRepairRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class ScheduleRepairRepositoryImpl implements ScheduleRepairRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Schedulerepair> getScheduleRepair() {
        Session s = this.factory.getObject().getCurrentSession();                
        Query q = s.createQuery("From Schedulerepair");
        return q.getResultList();
    }

    @Override
    public Schedulerepair getScheduleRepairById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Schedulerepair.class, id);        
    }

    @Override
    public void deleteScheduleRepair(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.remove(this.getScheduleRepairById(id));
    }

    @Override
    public void addOrUpdateScheduleRepair(Schedulerepair r) {
        Session s = this.factory.getObject().getCurrentSession();
        if(r.getId() != null)
        {
            s.update(r);
        }
        else
        {
            s.save(r);
        }        
    }        
}
