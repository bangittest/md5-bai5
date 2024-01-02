package com.ra.service;

import com.ra.model.entity.Category;
import com.ra.reponsitory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public void delete(Long id) {
    categoryRepository.deleteById(id);
    }
}
