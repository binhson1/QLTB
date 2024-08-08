/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Report;
import com.husony.repository.ReportRepository;
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
public class ReportRepositoryImpl implements ReportRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Report> getReports() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Report");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Report r) {
        Session s = this.factory.getObject().getCurrentSession();
        if (r.getId() != null) {
            s.update(r);
        } else {
            s.save(r);
        }
    }

    @Override
    public Report getReportById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Report.class, id);
    }

    @Override
    public void deleteReport(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Report r = this.getReportById(id);
        s.delete(r);
    }
    
}
