/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.service.impl;

import com.husony.pojo.Post;
import com.husony.repository.PostRepository;
import com.husony.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ACER
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepo;
    
    @Override
    public List<Post> getPosts() {
        return this.postRepo.getPosts();
    }

    @Override
    public void addOrUpdate(Post p) {
        this.postRepo.addOrUpdate(p);
    }

    @Override
    public Post getPostById(long id) {
        return this.postRepo.getPostById(id);
    }
    
}
