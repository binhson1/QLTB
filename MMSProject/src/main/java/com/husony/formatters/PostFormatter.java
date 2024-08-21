/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.formatters;

import com.husony.pojo.Manufacturer;
import com.husony.pojo.Post;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Do Gia Huy
 */
public class PostFormatter implements Formatter<Post> {
    @Override
    public String print(Post p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public Post parse(String postId, Locale locale) throws ParseException {
        Post m = new Post();
        m.setId(Long.parseLong(postId));
        
        return m;
    }
}
