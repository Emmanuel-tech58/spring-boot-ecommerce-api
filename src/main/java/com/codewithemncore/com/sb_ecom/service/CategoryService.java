package com.codewithemncore.com.sb_ecom.service;

import com.codewithemncore.com.sb_ecom.dto.category.CategoryCreateDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryReadDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryUpdateDTO;
import com.codewithemncore.com.sb_ecom.exception.DuplicateResourceException;
import com.codewithemncore.com.sb_ecom.exception.ResourceNotFoundException;
import com.codewithemncore.com.sb_ecom.mapper.CategoryMapper;
import com.codewithemncore.com.sb_ecom.model.Category;
import com.codewithemncore.com.sb_ecom.repositories.CategoryRepository;
import com.codewithemncore.com.sb_ecom.repositories.specification.CategorySpecification;
import com.codewithemncore.com.sb_ecom.service.interfaces.CategoryServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServiceInterface{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    @Transactional
    public CategoryReadDTO create(CategoryCreateDTO dto) {
        categoryRepository.findByNameIgnoreCase(dto.name())
                .ifPresent(existing -> {
                    throw new DuplicateResourceException("Category '" + dto.name() + "' already exists");
                });
        Category category = categoryMapper.toEntity(dto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    @Transactional
    public CategoryReadDTO updated(Long id, CategoryUpdateDTO dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category not found: " + id));
        categoryMapper.updateEntityFromDto(dto, category);
        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public void delete(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category not found: " + id));
        categoryRepository.delete(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryReadDTO> getAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryReadDTO getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + id + " not found"));

        return categoryMapper.toDto(category);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CategoryReadDTO> getPaged(int pageNumber, int pageSize, String searchTerm) {
        Specification<Category> spec = Specification
                .where(CategorySpecification.nameContains(searchTerm))
                .and(CategorySpecification.isActive());

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("name").ascending());

        return categoryRepository.findAll(spec, pageable).map(categoryMapper::toDto);
    }
}
