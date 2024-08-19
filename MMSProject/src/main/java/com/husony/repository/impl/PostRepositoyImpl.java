/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Post;
import com.husony.repository.PostRepository;
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
public class PostRepositoyImpl implements PostRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Post> getPosts() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Post> q = b.createQuery(Post.class);
        Root root = q.from(Post.class);
        q.select(root);
        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public void addOrUpdate(Post p) {
        Session s = this.factory.getObject().getCurrentSession();
        if(p.getId() != null)
        {
            s.update(p);            
        }
        else{
            s.save(p);            
        }
    }

    @Override
    public Post getPostById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Post.class, id);
    }
    
}
