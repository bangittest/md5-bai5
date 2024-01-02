package com.ra.service;

import com.ra.model.entity.Todolist;

import java.util.List;

public interface TodolistService {
    List<Todolist> getAll();
    Todolist save(Todolist todolist);
    Todolist findById(Long id);
    void delete(Long id);
}
