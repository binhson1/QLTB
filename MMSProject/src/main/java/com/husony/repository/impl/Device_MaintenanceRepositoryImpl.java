/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.pojo.DeviceMaintenance;
import com.husony.repository.Device_MaintenanceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class Device_MaintenanceRepositoryImpl implements Device_MaintenanceRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<DeviceMaintenance> getDeviceMaintenance(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<DeviceMaintenance> q = b.createQuery(DeviceMaintenance.class);
        Root root = q.from(DeviceMaintenance.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("scheduleMaintenanceId").get("id"), Long.parseLong(params.get("scheduleMaintenanceId")));
        q.where(p1);
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void addOrUpdate(DeviceMaintenance c) {
        Session s = this.factory.getObject().getCurrentSession();
        if (c.getId() != null) {
            s.update(c);
        } else {
            s.save(c);
        }
    }

    @Override
    public DeviceMaintenance getDeviceMaintenanceById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(DeviceMaintenance.class, id);
    }

    @Override
    public void deleteDeviceMaintenance(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getDeviceMaintenanceById(id));
    }

    @Override
    public DeviceMaintenance getDeviceMaintenanceByDeviceAndMaintenance(long deviceId, long scheduleMaintenanceId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<DeviceMaintenance> q = b.createQuery(DeviceMaintenance.class);
        Root root = q.from(DeviceMaintenance.class);
        q.select(root);
        List<Predicate> predicates = new ArrayList<>();
        Predicate p1 = b.equal(root.get("scheduleMaintenanceId").get("id"), scheduleMaintenanceId);
        Predicate p2 = b.equal(root.get("deviceId").get("id"), deviceId);
        predicates.add(p1);
        predicates.add(p2);
        q.where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q);
        List<DeviceMaintenance> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
    
}
