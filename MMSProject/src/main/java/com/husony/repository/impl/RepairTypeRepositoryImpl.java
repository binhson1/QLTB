/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Repairtype;
import com.husony.repository.RepairTypeRepository;
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
public class RepairTypeRepositoryImpl implements RepairTypeRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Repairtype> getRepairType() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Repairtype> q = b.createQuery(Repairtype.class);
        Root root = q.from(Repairtype.class);
        q.select(root);
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Repairtype getRepairTypeById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Repairtype.class, id);
    }

    @Override
    public void addOrUpdateRepairType(Repairtype r) {
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
    public void deleteRepairType(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.remove(this.getRepairTypeById(id));
    }
    
}
