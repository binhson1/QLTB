/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.husony.pojo.Post;
import com.husony.service.PostService;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/api")
@CrossOrigin
public class ApiPostController {

    @Autowired
    private PostService postService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "postId") long id) {
        return new ResponseEntity<>(this.postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> list() {
        return new ResponseEntity<>(this.postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping("/post/addOrUpdate")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addOrUpdate(@RequestBody @Valid Post p, BindingResult rs) throws ParseException {
        if (rs.hasErrors()) {
            System.out.println(rs);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        this.postService.addOrUpdate(p);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> uploadImage(@RequestParam("upload") MultipartFile file) throws IOException {
        System.out.println("upload");
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "No file uploaded"));            
        }

        Map res = this.cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("resource_type", "auto"));

        String imageUrl = res.get("url").toString();                
        Map<String, Object> response = new HashMap<>();
        
        response.put("uploaded", true);
        response.put("url", imageUrl);
        
        return ResponseEntity.ok(response);
    }
}
