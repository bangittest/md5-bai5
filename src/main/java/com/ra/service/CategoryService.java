package com.ra.service;

import com.ra.model.dto.category.CategoryDTO;
import com.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<CategoryDTO>categoryNavigation(Pageable pageable);
    List<Category>getAll();
    Category save(Category category);
    Category findById(Long id);
    void delete(Long id);
    Page<CategoryDTO>categoryNavigationSeach(Pageable pageable,String name);
}
