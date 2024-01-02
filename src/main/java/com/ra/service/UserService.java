package com.ra.service;

import com.ra.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    User findById(Long id);
}
