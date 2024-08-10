/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.repository.DeviceRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
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
public class DeviceRepositoryImpl implements DeviceRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Device> getDevices() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Device");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Device d) {
        Session s = this.factory.getObject().getCurrentSession();
        if (d.getId() != null) {
            s.update(d);
        } else {
            s.save(d);
        }
    }

    @Override
    public Device getDeviceById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Device.class, id);
    }

    @Override
    public void deleteDevice(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Device d = this.getDeviceById(id);
        s.delete(d);
    }
    
}
