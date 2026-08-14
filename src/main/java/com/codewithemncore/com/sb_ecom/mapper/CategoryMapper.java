package com.codewithemncore.com.sb_ecom.mapper;

import com.codewithemncore.com.sb_ecom.dto.category.CategoryReadDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryUpdateDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryCreateDTO;
import com.codewithemncore.com.sb_ecom.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryCreateDTO dto);
    CategoryReadDTO toDto(Category category);
    List<CategoryReadDTO> toDtoList(List<Category> categories);
    void updateEntityFromDto(CategoryUpdateDTO dto, @MappingTarget Category entity);
}
