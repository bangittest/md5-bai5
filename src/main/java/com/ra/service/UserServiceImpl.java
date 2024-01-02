package com.ra.service;

import com.ra.model.entity.User;
import com.ra.reponsitory.UserResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserResponsitory userResponsitory;
    @Override
    public List<User> findAll() {
        return userResponsitory.findAll();
    }

    @Override
    public User save(User user) {
        return userResponsitory.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user=userResponsitory.findById(id);
        return user.orElse(null);
    }
}
