/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Manufacturer;
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
import com.husony.repository.ManufacturerRepository;
import java.util.ArrayList;
import java.util.Map;
import javax.persistence.criteria.Predicate;

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class ManufacturerRepositoryImpl implements ManufacturerRepository {
    private static final int PAGE_SIZE = 4;

    @Autowired
    private LocalSessionFactoryBean factory;

    public List<Manufacturer> getManufac(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Manufacturer> q = b.createQuery(Manufacturer.class);
        Root root = q.from(Manufacturer.class);
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

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int start = (p - 1) * PAGE_SIZE;

                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
            }
        }

        return query.getResultList();
    }

    @Override
    public void addOrUpdateManu(Manufacturer m) {
        Session s = this.factory.getObject().getCurrentSession();
        if (m.getId() != null) {
            s.update(m);
        } else {
            s.save(m);
        }

    }

    @Override
    public Manufacturer getManuById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Manufacturer.class, id);
    }

    @Override
    public void deleteManu(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Manufacturer m = this.getManuById(id);
        s.delete(m);
    }

}
