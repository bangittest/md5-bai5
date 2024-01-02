package com.ra.controller;

import com.ra.model.entity.User;
import com.ra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>>findAll(){
        List<User> userList=userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<?>createUser(@RequestBody User user){
        if (user!=null){
            User user1=userService.save(user);
            return new ResponseEntity<>(user1, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
}
