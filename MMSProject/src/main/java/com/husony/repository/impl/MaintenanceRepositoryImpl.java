/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Schedulemaintenance;
import com.husony.repository.MaintenanceRepository;
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
public class MaintenanceRepositoryImpl implements MaintenanceRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Schedulemaintenance> getMaintenance() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Schedulemaintenance");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Schedulemaintenance d) {
        Session s = this.factory.getObject().getCurrentSession();
        if (d.getId() != null) {
            s.update(d);
        } else {
            s.save(d);
        }
    }

    @Override
    public Schedulemaintenance getMaintenanceById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Schedulemaintenance.class, id);
    }

    @Override
    public void deleteMaintenance(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getMaintenanceById(id));
    }
    
}
