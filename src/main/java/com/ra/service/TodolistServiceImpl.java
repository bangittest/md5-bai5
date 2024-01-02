package com.ra.service;

import com.ra.model.entity.Todolist;
import com.ra.reponsitory.TodolistReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodolistServiceImpl implements TodolistService{
    @Autowired
    TodolistReponsitory todolistReponsitory;
    @Override
    public List<Todolist> getAll() {
        return todolistReponsitory.findAll();
    }

    @Override
    public Todolist save(Todolist todolist) {
        return todolistReponsitory.save(todolist);
    }

    @Override
    public Todolist findById(Long id) {
        Optional<Todolist> todolist=todolistReponsitory.findById(id);
        return todolist.orElse(null);
    }

    @Override
    public void delete(Long id) {
    todolistReponsitory.deleteById(id);
    }
}
