package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public ResponseEntity<List<Category>>category(){
        List<Category> list=categoryService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/category")
    public ResponseEntity<Category>create(@RequestBody Category category){
        Category cateNew=categoryService.save(category);
        return new ResponseEntity<>(cateNew,HttpStatus.CREATED);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<?>findById(@PathVariable("id")Long id){
        Category category=categoryService.findById(id);
        if (category!=null){
            return new ResponseEntity<>(category,HttpStatus.OK);
        }
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<Category>update(@PathVariable Long id, @RequestBody Category category){
        Category categoryUpdate=categoryService.findById(id);
        categoryUpdate.setCategoryName(category.getCategoryName());
        categoryUpdate.setStatus(category.getStatus());
        Category categoryNew=categoryService.save(categoryUpdate);
        return new ResponseEntity<>(categoryNew,HttpStatus.OK);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
//        try {
//            categoryService.delete(id);
//            return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        if (categoryService.findById(id)!=null){
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("{'mess':'not found'}",HttpStatus.NOT_FOUND);
    }
}
