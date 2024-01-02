package com.ra.reponsitory;

import com.ra.model.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistReponsitory extends JpaRepository<Todolist,Long> {
}
