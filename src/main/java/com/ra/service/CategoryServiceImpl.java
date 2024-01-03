package com.ra.service;

import com.ra.model.dto.category.CategoryDTO;
import com.ra.model.entity.Category;
import com.ra.reponsitory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<CategoryDTO> categoryNavigation(Pageable pageable) {

        Page<Category>categories=categoryRepository.findAll(pageable);

        return categories.map(category -> new CategoryDTO(category.getId(),category.getCategoryName(),category.getStatus()));
    }

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

    @Override
    public Page<CategoryDTO> categoryNavigationSeach(Pageable pageable, String name) {
        Page<Category>categories=categoryRepository.searchAllByCategoryNameContainingIgnoreCase(pageable,name);
        return categories.map(category -> new CategoryDTO(category.getId(),category.getCategoryName(),category.getStatus()));
    }
}
