package com.ra.controller;

import com.ra.model.entity.Todolist;
import com.ra.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TodolistController {
    @Autowired
    TodolistService todolistService;
    @GetMapping("/todolist")
    public ResponseEntity<List<Todolist>>todolist(){
        List<Todolist> todolistList=todolistService.getAll();
        return new ResponseEntity<>(todolistList, HttpStatus.OK);
    }

    @PostMapping("/todolist")
    public ResponseEntity<Todolist>create(@RequestBody Todolist todolist){
        Todolist todolistNew=todolistService.save(todolist);
        return new ResponseEntity<>(todolistNew,HttpStatus.CREATED);
    }

    @GetMapping("todolist/{id}")
    public ResponseEntity<?>edit(@PathVariable("id") Long id){
        Todolist todolist=todolistService.findById(id);
        if (todolist==null){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(todolist,HttpStatus.OK);
    }

    @PutMapping("todolist/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody Todolist todolist){
        Todolist todo=todolistService.findById(id);
        if (todolist==null){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        todo.setName(todolist.getName());
        todo.setStatus(todolist.getStatus());
        Todolist todolistUpdate=todolistService.save(todolist);
        return new ResponseEntity<>(todolistUpdate,HttpStatus.OK);
    }
    @PatchMapping("todolist/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        Todolist todolistUpdateStatus=todolistService.findById(id);
        if (todolistUpdateStatus==null){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        todolistUpdateStatus.setStatus(!todolistUpdateStatus.getStatus());
        Todolist todolistUp=todolistService.save(todolistUpdateStatus);
        return new ResponseEntity<>(todolistUp,HttpStatus.OK);
    }
    @DeleteMapping("todolist/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        Todolist todolist=todolistService.findById(id);
        if (todolist==null){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        todolistService.delete(id);
        return new ResponseEntity<>("success",HttpStatus.NO_CONTENT);
    }
}
