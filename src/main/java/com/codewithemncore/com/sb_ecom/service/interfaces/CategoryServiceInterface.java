package com.codewithemncore.com.sb_ecom.service.interfaces;

import com.codewithemncore.com.sb_ecom.model.Category;

import java.util.List;

public interface CategoryServiceInterface {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long id);
    Category updateCategory(Category category, Long id);
}
