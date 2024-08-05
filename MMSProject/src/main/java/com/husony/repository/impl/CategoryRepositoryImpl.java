/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Devicecategory;
import com.husony.repository.CategoryRepository;
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

/**
 *
 * @author ACER
 */
@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    
    public List<Devicecategory> getCates() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Devicecategory> q = b.createQuery(Devicecategory.class);
        Root root = q.from(Devicecategory.class);
        q.select(root);
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void addOrUpdateCate(Devicecategory c) {
        Session s = this.factory.getObject().getCurrentSession();
        if(c.getId() != null){
            s.update(c);
        }
        else{
            s.save(c);
        }
    }

    @Override
    public Devicecategory getCateById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Devicecategory.class, id);
    }

    @Override
    public void deleteCate(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Devicecategory c = this.getCateById(id);
        s.delete(c);
    }
    
}
