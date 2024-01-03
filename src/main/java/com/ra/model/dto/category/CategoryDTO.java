package com.ra.model.dto.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.model.entity.Product;
import jakarta.persistence.*;

import java.util.List;

public class CategoryDTO {
    private Long id;

    private String categoryName;

    private Boolean status=true;
    //    @OneToMany(mappedBy = "category")
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String categoryName, Boolean status) {
        this.id = id;
        this.categoryName = categoryName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
