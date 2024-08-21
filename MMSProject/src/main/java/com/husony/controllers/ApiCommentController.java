/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.husony.pojo.Comment;
import com.husony.service.CommentService;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Do Gia Huy
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    
//    @DeleteMapping("/category/delete/{categoryId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable(value = "categoryId") long id) {
//        this.cateService.deleteCate(id);
//    }
    
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getCommentByPostId(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.commentService.getComment(params), HttpStatus.OK);
    }
    
    @PostMapping("/comment/addOrUpdate")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addOrUpdate(@RequestBody @Valid Comment c, BindingResult rs) throws ParseException {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.commentService.addOrUpdate(c);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
