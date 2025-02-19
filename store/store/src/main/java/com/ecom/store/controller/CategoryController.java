package com.ecom.store.controller;

import com.ecom.store.model.Category;
import com.ecom.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
}
