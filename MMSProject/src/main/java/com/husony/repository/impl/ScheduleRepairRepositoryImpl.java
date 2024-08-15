/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Manufacturer;
import com.husony.pojo.Report;
import com.husony.pojo.Schedulerepair;
import com.husony.repository.ScheduleRepairRepository;
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
public class ScheduleRepairRepositoryImpl implements ScheduleRepairRepository {

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
        if (r.getId() != null) {
            s.update(r);
        } else {
            s.save(r);
        }
    }

    @Override
    public List<Schedulerepair> getScheduleRepairByDeviceId(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Report> q1 = b.createQuery(Report.class);
        Root root = q1.from(Report.class);
        q1.select(root);

        CriteriaQuery<Schedulerepair> q2 = b.createQuery(Schedulerepair.class);
        Root root2 = q2.from(Schedulerepair.class);
        q2.select(root2);

        List<Predicate> predicates = new ArrayList<>();

        Predicate p1 = b.equal(root.get("deviceId").get("id"), id);
        predicates.add(p1);

        q1.where(predicates.toArray(Predicate[]::new));
        Query query = s.createQuery(q1);

        List<Report> reportList = query.getResultList();

        List<Predicate> schedulerepairPredicates = new ArrayList<>();
        for (Report report : reportList) {
            schedulerepairPredicates.add(b.equal(root2.get("reportId").get("id"), report.getId()));
        }

        q2.where(b.or(schedulerepairPredicates.toArray(new Predicate[0])));

        Query<Schedulerepair> schedulerepairQueryResult = s.createQuery(q2);
        return schedulerepairQueryResult.getResultList();
    }
}
