package com.codewithemncore.com.sb_ecom.service;

import com.codewithemncore.com.sb_ecom.model.Category;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceInterface {

    private final List<Category> categories;

    public CategoryService(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        int size = categories.size();
        category.setId((long) (size + 1));
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categories.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst().orElse(null);
        if(category == null)
            return "No category with Id " + id + " Exists";
        categories.remove(category);
        return "Category with Id " + id + " Deleted successfully";
    }
}
