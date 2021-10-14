package com.backend.ecommerce.service;

import com.backend.ecommerce.model.Category;
import com.backend.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);
    }
    public List<Category> listCategory(){
        return categoryRepository.findAll();
    }
    public void editCategory(int categoryId, Category updateCategory){
        Category category = categoryRepository.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        category.setUpdate_at(updateCategory.getUpdate_at());
        categoryRepository.save(category);
    }

    public boolean findById(int id){
        return categoryRepository.findById(id).isPresent();
    }
}
