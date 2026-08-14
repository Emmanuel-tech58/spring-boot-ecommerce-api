package com.codewithemncore.com.sb_ecom.controller;

import com.codewithemncore.com.sb_ecom.dto.category.CategoryCreateDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryReadDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryUpdateDTO;
import com.codewithemncore.com.sb_ecom.dto.common.PageRequestParams;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/paged")
    public ResponseEntity<Page<CategoryReadDTO>> getPAged(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String searchTerm,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection ){

        var params = new PageRequestParams(pageNumber, pageSize, searchTerm, sortBy, sortDirection);
        return ResponseEntity.ok(categoryService.getPaged(params));
    }
}