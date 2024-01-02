package com.ra.controller;

import com.ra.model.dto.product.ProductDTO;
import com.ra.model.entity.Product;
import com.ra.service.CategoryService;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/product")
    public ResponseEntity<List<Product>>product(){
        List<Product>products=productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
           if (productDTO!=null){
               ProductDTO savedProductDTO = productService.addProduct(productDTO);
               return new ResponseEntity<>(savedProductDTO, HttpStatus.CREATED);
           }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?>findIdProduct(@PathVariable Long id){
        ProductDTO product=productService.findById(id);
        if (product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO, @PathVariable("id") Long id) {
        ProductDTO editProduct = productService.findById(id);

        if (editProduct == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

        editProduct.setProductName(productDTO.getProductName());
        editProduct.setPrice(productDTO.getPrice());
        editProduct.setCategoryId(productDTO.getCategoryId());
        ProductDTO updatedProduct = productService.update(editProduct);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<?>deleteProduct(@PathVariable("id")Long id){
        ProductDTO product=productService.findById(id);
        if (product==null){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
