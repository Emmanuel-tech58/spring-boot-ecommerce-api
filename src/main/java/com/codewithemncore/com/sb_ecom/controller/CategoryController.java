package com.codewithemncore.com.sb_ecom.controller;

import com.codewithemncore.com.sb_ecom.model.Category;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryServiceInterface categoryService;

    public CategoryController(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category " + category.getName() + " created successfully";
    }

    @DeleteMapping("/api/admin/categories/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
}
