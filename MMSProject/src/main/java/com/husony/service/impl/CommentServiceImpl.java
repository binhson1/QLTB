/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Comment;
import com.husony.repository.CommentRepository;
import com.husony.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Do Gia Huy
 */
@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository commentRepo;

    @Override
    public List<Comment> getComment(Map<String, String> params) {
        return this.commentRepo.getComment(params);
    }

    @Override
    public void addOrUpdate(Comment d) {
        this.commentRepo.addOrUpdate(d);
    }

    @Override
    public Comment getCommentById(long id) {
        return this.commentRepo.getCommentById(id);
    }

    @Override
    public void deleteComment(long id) {
        this.commentRepo.deleteComment(id);
    }
    
}
