/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Location;
import com.husony.repository.LocationRepository;
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
 * @author Do Gia Huy
 */
@Repository
@Transactional
public class LocationRepositoryImpl implements LocationRepository {
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Location> getLocations() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Location");
        return q.getResultList();
    }

    @Override
    public void addOrUpdate(Location l) {
        Session s = this.factory.getObject().getCurrentSession();
        if (l.getId() != null) {
            s.update(l);
        } else {
            s.save(l);
        }
    }

    @Override
    public Location getLocationById(long l) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Location.class, l);
    }

    @Override
    public void deleteLocation(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        s.remove(this.getLocationById(id));
    }
    
}
