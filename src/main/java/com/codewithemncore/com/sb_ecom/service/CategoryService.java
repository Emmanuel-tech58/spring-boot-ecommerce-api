package com.codewithemncore.com.sb_ecom.service;

import com.codewithemncore.com.sb_ecom.model.Category;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category with Id " + id + " Exists"));
        categories.remove(category);
        return "Category with Id " + id + " Deleted successfully";
    }

    @Override
    public String updateCategory(Category category) {
        Category localCategory = categories.stream()
                .filter(c -> c.getId().equals(category.getId()))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "This product does not exist"));
        categories.add((int)(localCategory.getId() -1), category);
        return "updated successfully";
    }
}
