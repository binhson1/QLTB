/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.husony.repository;

import com.husony.pojo.User;

/**
 *
 * @author ACER
 */
public interface UserRepository {

    User getUserByUsername(String username);

    boolean authUser(String username, String password);

    User addUser(User user);
}
