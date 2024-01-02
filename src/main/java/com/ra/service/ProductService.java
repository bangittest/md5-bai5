package com.ra.service;


import com.ra.model.dto.product.ProductDTO;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    ProductDTO findById(Long id);
    Product findByIdProduct(Long id);
    void delete(Long id);
}
