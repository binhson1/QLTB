/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Maintenancetype;
import com.husony.repository.MaintenanceTypeRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class MaintenanceTypeRepositoryImpl implements MaintenanceTypeRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Maintenancetype> getMaintenanceType() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Maintenancetype> q = b.createQuery(Maintenancetype.class);
        Root root = q.from(Maintenancetype.class);
        q.select(root);
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Maintenancetype getMaintenanceTypeById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Maintenancetype.class, id);
    }

    @Override
    public void addOrUpdateMaintenanceType(Maintenancetype m) {
        Session s = this.factory.getObject().getCurrentSession();
        if(m.getId() != null)
        {
            s.update(m);
        }
        else
        {
            s.save(m);
        }
    }

    @Override
    public void deleteMaintenanceType(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getMaintenanceTypeById(id));
    }
    
}
