package com.codewithemncore.com.sb_ecom.controller;

import com.codewithemncore.com.sb_ecom.dto.category.CategoryCreateDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryReadDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryUpdateDTO;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceInterface categoryService;

    @PostMapping
    public ResponseEntity<CategoryReadDTO> create(@Valid @RequestBody CategoryCreateDTO createRequest){
        CategoryReadDTO category = categoryService.create(createRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryReadDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryUpdateDTO updateBody){
        CategoryReadDTO category = categoryService.updated(id, updateBody);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryReadDTO> getById(@PathVariable Long id){
        CategoryReadDTO category = categoryService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryReadDTO>> gateAll(){
        List<CategoryReadDTO> categories = categoryService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}