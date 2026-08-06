package com.codewithemncore.com.sb_ecom.service;

import com.codewithemncore.com.sb_ecom.model.Category;
import com.codewithemncore.com.sb_ecom.repositories.CategoryRepository;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category with Id " + id + " Exists"));
        categoryRepository.delete(category);
        return "Category with Id " + id + " Deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long id) {

        Category savedCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category with Id " + id + " Exists"));

        category.setId(savedCategory.getId());
        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
