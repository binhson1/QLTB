/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Device;
import com.husony.pojo.Schedulemaintenance;
import com.husony.repository.MaintenanceRepository;
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
 * @author Do Gia Huy
 */
@Repository
@Transactional
public class MaintenanceRepositoryImpl implements MaintenanceRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Schedulemaintenance> getMaintenance(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Schedulemaintenance> q = b.createQuery(Schedulemaintenance.class);
        Root root = q.from(Schedulemaintenance.class);
        q.select(root);

        if (params != null) {
            try {
                List<Predicate> predicates = new ArrayList<>();
                String nextMaintenanceDate = params.get("nextMaintenanceDate");

                if (nextMaintenanceDate != null && !nextMaintenanceDate.isEmpty()) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date next_maintenance_date = formatter.parse(nextMaintenanceDate);
                    Predicate p1 = b.equal(root.get("nextMaintenanceDate").as(Date.class), next_maintenance_date);
                    predicates.add(p1);
                }

                String maintenanceTypeId = params.get("maintenanceTypeId");
                if (maintenanceTypeId != null && !maintenanceTypeId.isEmpty()) {
                    Predicate p2 = b.equal(root.get("maintenanceTypeId").get("id"), Long.parseLong(maintenanceTypeId));
                    predicates.add(p2);
                }

                String kw = params.get("q");
                if (kw != null && !kw.isEmpty()) {
                    Predicate p3 = b.like(root.get("name"), String.format("%%%s%%", kw));
                    predicates.add(p3);
                }

                q.where(predicates.toArray(Predicate[]::new));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public void addOrUpdate(Schedulemaintenance d) {
        Session s = this.factory.getObject().getCurrentSession();
        if (d.getId() != null) {
            s.update(d);
        } else {
            s.save(d);
        }
    }

    @Override
    public Schedulemaintenance getMaintenanceById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Schedulemaintenance.class, id);
    }

    @Override
    public void deleteMaintenance(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getMaintenanceById(id));
    }

}
