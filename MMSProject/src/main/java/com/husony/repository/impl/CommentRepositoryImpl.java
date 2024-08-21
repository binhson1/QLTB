/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.repository.impl;

import com.husony.pojo.Comment;
import com.husony.repository.CommentRepository;
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
public class CommentRepositoryImpl implements CommentRepository {
    private static final int PAGE_SIZE = 4;
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Comment> getComment(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String postId = params.get("postId");
            if (postId != null && !postId.isEmpty()) {
                Predicate p1 = b.equal(root.get("postId").get("id"), Long.parseLong(postId));
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
    public void addOrUpdate(Comment d) {
        Session s = this.factory.getObject().getCurrentSession();
        if (d.getId() != null) {
            s.update(d);
        } else {
            s.save(d);
        }
    }

    @Override
    public Comment getCommentById(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Comment.class, id);
    }

    @Override
    public void deleteComment(long id) {
        Session s = this.factory.getObject().getCurrentSession();
        Comment d = this.getCommentById(id);
        s.delete(d);
    }
    
}
