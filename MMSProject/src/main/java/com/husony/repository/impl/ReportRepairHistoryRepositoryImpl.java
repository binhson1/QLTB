/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Reportrepairhistory;
import com.husony.repository.ReportRepairHistoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class ReportRepairHistoryRepositoryImpl implements ReportRepairHistoryRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Reportrepairhistory> getReportRepairHistorys(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Reportrepairhistory> q = b.createQuery(Reportrepairhistory.class);
        Root root = q.from(Reportrepairhistory.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("title"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            String reportId = params.get("reportId");
            if (reportId != null && !reportId.isEmpty()) {
                Predicate p2 = b.equal(root.get("reportId").get("id"), Long.parseLong(reportId));
                predicates.add(p2);
            }

            String deviceCategoryId = params.get("cateId");
            if (deviceCategoryId != null && !deviceCategoryId.isEmpty()) {
                Predicate p3 = b.equal(root.get("deviceCategoryId").get("id"), Long.parseLong(deviceCategoryId));
                predicates.add(p3);
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);


        return query.getResultList();
    }

    @Override
    public void addOrUpdate(Reportrepairhistory r) {
        Session s = this.factory.getObject().getCurrentSession();        
        if(r.getId() != null)
        {
            s.update(r);
        }
        else{
            s.save(r);
        }
    }

    @Override
    public Reportrepairhistory getReportRepairHistoryById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Reportrepairhistory.class, id);
    }

    @Override
    public void deleteReportRepairHistory(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.remove(this.getReportRepairHistoryById(id));
    }
    
}
