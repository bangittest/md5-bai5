package com.ra.reponsitory;

import com.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Page<Category>searchAllByCategoryNameContainingIgnoreCase(Pageable pageable,String name);
}
