/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.pojo.Locationhistory;
import com.husony.repository.LocationHistoryRepository;
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
        Predicate p1 = b.equal(root.get("deviceId").as(Device.class), d);
        Predicate p2 = b.equal(root.get("active").as(Boolean.class), true);
        q = q.where(b.and(p1, p2));
        Query query = s.createQuery(q);
        return s.get(Locationhistory.class, query.getFirstResult());
    }

}
