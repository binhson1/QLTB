/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.pojo.Schedulerepair;
import com.husony.repository.ScheduleRepairRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author ACER
 */
@Repository
@Transactional
public class ScheduleRepairRepositoryImpl implements ScheduleRepairRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Schedulerepair> getScheduleRepair(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Schedulerepair> q = b.createQuery(Schedulerepair.class);
        Root root = q.from(Schedulerepair.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            try {
                String strDate = params.get("date");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(strDate);
                if (strDate != null && !strDate.isEmpty()) {
                    Predicate p2 = b.equal(root.get("date"), date);
                    predicates.add(p2);
                }
            } catch (ParseException ex) {
                System.err.println(ex.getMessage());
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        return query.getResultList();
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
}
