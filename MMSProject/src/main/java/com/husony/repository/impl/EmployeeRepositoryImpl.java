/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Employee;
import com.husony.pojo.Location;
import com.husony.repository.EmployeeRepository;
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
 * @author ACER
 */
@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Employee> getEmployee(Map<String, String> params) {
       Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Employee> q = b.createQuery(Employee.class);
        Root root = q.from(Employee.class);
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

        return query.getResultList();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Employee.class, id);
    }

    @Override
    public void addOrUpdateEmployee(Employee e) {
        Session s = this.factory.getObject().getCurrentSession();

        if(e.getId() != null)
        {
            s.update(e);
        }
        else
        {
            s.save(e);
        }
    }

    @Override
    public void deleteEmployee(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(this.getEmployeeById(id));
    }
    
}
