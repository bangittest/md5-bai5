package com.ra.reponsitory;

import com.ra.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReponsitory extends JpaRepository<Product,Long> {
}
