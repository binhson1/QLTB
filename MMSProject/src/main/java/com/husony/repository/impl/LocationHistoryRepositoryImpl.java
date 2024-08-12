/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;
import com.husony.repository.LocationHistoryRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
public class LocationHistoryRepositoryImpl implements LocationHistoryRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public Locationhistory getLocationByDevice(Device d) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Locationhistory> q = b.createQuery(Locationhistory.class);
        Root root = q.from(Locationhistory.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("deviceId"), d);
        Predicate p2 = b.equal(root.get("active"), true);
        q = q.where(b.and(p1, p2));
        Query query = s.createQuery(q);
        List<Locationhistory> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void createLocationDevice(Locationhistory l) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(l);
    }

    @Override
    public void updateLocationDevice(Locationhistory l) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(l);
    }

    @Override
    public List<Locationhistory> getDevicesByLocation(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Locationhistory> q = b.createQuery(Locationhistory.class);
        Root root = q.from(Locationhistory.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("locationId").get("id"), id);
        Predicate p2 = b.equal(root.get("active"), true);
        q = q.where(b.and(p1, p2));
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Locationhistory> getLocationHistoryByDevice(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Locationhistory> q = b.createQuery(Locationhistory.class);
        Root root = q.from(Locationhistory.class);
        q.select(root);
        Predicate p1 = b.equal(root.get("deviceId").get("id"), id);
        q = q.where(p1);
        q.orderBy(b.desc(root.get("beginDate"))); 
        Query query = s.createQuery(q);
        return query.getResultList();
    }
    
    
}
