package com.ra.controller;

import com.ra.model.dto.category.CategoryDTO;
import com.ra.model.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("v1/api/search")
    public ResponseEntity<?>searchCategory(@RequestParam(defaultValue = "0",name = "page") Integer noPage,
                                           @RequestParam(defaultValue = "5",name = "limit") Integer limit,
                                           @RequestParam(name = "keyword") String keyword,
                                           @RequestParam(defaultValue = "id" ,name = "sort") String sort,
                                           @RequestParam(defaultValue = "asc",name = "order")String order){
        Pageable pageable;
        if (order.equals("desc")){
            pageable=PageRequest.of(noPage,limit, Sort.by(sort).descending());
        }else {
            pageable=PageRequest.of(noPage,limit, Sort.by(sort).ascending());
        }
        Page<CategoryDTO>categoryDTOPage=categoryService.categoryNavigationSeach(pageable,keyword);
        return new ResponseEntity<>(categoryDTOPage,HttpStatus.OK);
    }

    @GetMapping("v1/api/category")
    public ResponseEntity<?>pageCategory(@RequestParam(defaultValue = "0" ,name = "page") int noPage,
                                         @RequestParam(defaultValue = "5",name = "limit")int limit){
        Pageable pageable= PageRequest.of(noPage,limit);
        Page<CategoryDTO>categories=categoryService.categoryNavigation(pageable);
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
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
