/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.service;

import com.husony.pojo.Comment;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Do Gia Huy
 */
public interface CommentService {
    List<Comment> getComment(Map<String, String> params);
    void addOrUpdate(Comment d);
    Comment getCommentById(long id);
    void deleteComment(long id);
}
