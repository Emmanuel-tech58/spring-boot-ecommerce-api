package com.codewithemncore.com.sb_ecom.controller;

import com.codewithemncore.com.sb_ecom.model.Category;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryServiceInterface categoryService;

    public CategoryController(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<?> getAllCategories(){
        try{
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(categories);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        try{
            categoryService.createCategory(category);
            return new ResponseEntity<>("Category " + category.getName() + " created successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/api/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        try{
            return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode()) ;
        }
    }

    @PutMapping("/api/admin/categories")
    public ResponseEntity<String> updateCategory(@RequestBody Category category){
        try{
            return ResponseEntity.ok(categoryService.updateCategory(category));
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode()) ;
        }
    }
}
