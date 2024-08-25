/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.pojo.Schedulerepair;
import com.husony.repository.StatsRepository;
import java.util.ArrayList;
import java.util.List;
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
 * @author ACER
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statsRevenueByDevice() {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rP = q.from(Device.class);

        q.multiselect(rP.get("id"), rP.get("name"), rP.get("status"));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> statsDeviceByCategory() {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rP = q.from(Device.class);

        q.multiselect(b.count(rP.get("id")), rP.get("deviceCategoryId").get("name")).groupBy(rP.get("deviceCategoryId").get("name"));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> statsDeviceByStatus() {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rP = q.from(Device.class);

        q.multiselect(b.count(rP.get("id")), rP.get("status")).groupBy(rP.get("status"));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> statsRepairCostDevice(int year, String period) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rP = q.from(Schedulerepair.class);

        q.multiselect(b.sum(rP.get("cost")), rP.get("reportId").get("deviceId").get("name"));
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.equal(b.function("YEAR", Integer.class, rP.get("date")), year));
        q.where(predicates.toArray(Predicate[]::new));
        q.groupBy(rP.get("reportId").get("deviceId").get("name"));
        q.groupBy(b.function(period, Integer.class, rP.get("date")));
        
        Query query = s.createQuery(q);

        return query.getResultList();
    }

}
