package com.ra.service;

import com.ra.model.dto.product.ProductDTO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.reponsitory.ProductReponsitory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductReponsitory productReponsitory;
    @Autowired
    CategoryService categoryService;

    @Override
    public List<Product> getAll() {
//        List<Product>products=productReponsitory.findAll();
//        List<ProductDTO>productDTOList=new ArrayList<>();
//        for (Product product:products) {
//           ProductDTO productDTO=new ProductDTO();
//           productDTO.setId(product.getId());
//           productDTO.setProductName(product.getProductName());
//           productDTO.setPrice(product.getPrice());
//           productDTO.setCategoryId(product.getCategory().getId());
//            productDTOList.add(productDTO);
//        }
//        return productDTOList;
      return  productReponsitory.findAll();
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());

        Category category = categoryService.findById(productDTO.getCategoryId()); // Corrected line
        product.setCategory(category);

        productReponsitory.save(product);
        productDTO.setId(product.getId());
        return productDTO;
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Optional<Product> productUpdate = productReponsitory.findById(productDTO.getId());

        if (productUpdate!=null) {
            Product editProduct = productUpdate.get();
            editProduct.setProductName(productDTO.getProductName());
            editProduct.setPrice(productDTO.getPrice());

            Category category = categoryService.findById(productDTO.getCategoryId());
            editProduct.setCategory(category);
            productReponsitory.save(editProduct);
            return productDTO;
        } else {
            return null;
        }
    }


    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> optionalProduct = productReponsitory.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTO.setPrice(product.getPrice());
            productDTO.setCategoryId(product.getCategory().getId());
            return productDTO;
        } else {
            throw new EntityNotFoundException("Product with ID " + id + " not found");
        }
    }

    @Override
    public Product findByIdProduct(Long id) {
        Optional<Product> product=productReponsitory.findById(id);
        return product.orElse(null);
    }

    @Override
    public void delete(Long id) {
        if (productReponsitory.existsById(id)) {
            productReponsitory.deleteById(id);
        } else {
            throw new EntityNotFoundException("Product with ID " + id + " not found");
        }
    }

}
