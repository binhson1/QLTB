/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.repository.DeviceRepository;
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
public class DeviceRepositoryImpl implements DeviceRepository {
    private static final int PAGE_SIZE = 4;
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Device> getDevices(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Device> q = b.createQuery(Device.class);
        Root root = q.from(Device.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("q");
            if (kw != null && !kw.isEmpty()) {
                Predicate p1 = b.like(root.get("name"), String.format("%%%s%%", kw));
                predicates.add(p1);
            }

            String manuId = params.get("manuId");
            if (manuId != null && !manuId.isEmpty()) {
                Predicate p2 = b.equal(root.get("manufacturerId").get("id"), Long.parseLong(manuId));
                predicates.add(p2);
            }

            String cateId = params.get("cateId");
            if (cateId != null && !cateId.isEmpty()) {
                Predicate p3 = b.equal(root.get("deviceCategoryId").get("id"), Long.parseLong(cateId));
                predicates.add(p3);
            }
            
            String status = params.get("status");
            if (status != null && !status.isEmpty()) {
                Predicate p4 = b.equal(root.get("status"),status);
                predicates.add(p4);
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
    public void addOrUpdate(Device d) {
        Session s = this.factory.getObject().getCurrentSession();
        if (d.getId() != null) {
            s.update(d);
        } else {
            s.save(d);
        }
    }

    @Override
    public Device getDeviceById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Device.class, id);
    }

    @Override
    public void deleteDevice(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Device d = this.getDeviceById(id);
        s.delete(d);
    }
    
}
