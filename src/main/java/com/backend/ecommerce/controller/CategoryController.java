package com.backend.ecommerce.controller;

import com.backend.ecommerce.common.ApiResponse;
import com.backend.ecommerce.model.Category;
import com.backend.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "nouvelle categorie créee"), HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public List<Category> listCategory(){
        return categoryService.listCategory();
    }
    @PostMapping("update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
        if(!categoryService.findById(categoryId)) {
            return new ResponseEntity<>(new ApiResponse(false, "cette categorie n'existe pas"), HttpStatus.NOT_FOUND);
        }
        categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true,"categorie modifiée"), HttpStatus.OK);
    }
}
