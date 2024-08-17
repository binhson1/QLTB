/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Job;
import com.husony.pojo.Location;
import com.husony.repository.JobRepository;
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
public class JobRepositoryImpl implements JobRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Job> getJob(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Job> q = b.createQuery(Job.class);
        Root root = q.from(Job.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        javax.persistence.Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public Job getJobById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Job.class, id);
    }

    @Override
    public void deleteJob(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getJobById(id));
    }

    @Override
    public void addOrUpdate(Job j) {
        Session s = this.factory.getObject().getCurrentSession();
        if (j.getId() != null) {
            s.update(j);
        } else {
            s.save(j);
        }
    }
    
}
