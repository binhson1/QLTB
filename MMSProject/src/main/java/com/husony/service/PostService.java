/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Post;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface PostService {
    List<Post> getPosts();
    void addOrUpdate(Post p);
    Post getPostById(long id);
}
