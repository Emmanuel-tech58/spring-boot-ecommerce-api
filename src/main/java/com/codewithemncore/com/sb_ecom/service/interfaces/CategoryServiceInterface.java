package com.codewithemncore.com.sb_ecom.service.interfaces;

import com.codewithemncore.com.sb_ecom.dto.category.CategoryCreateDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryReadDTO;
import com.codewithemncore.com.sb_ecom.dto.category.CategoryUpdateDTO;
import com.codewithemncore.com.sb_ecom.dto.common.PageRequestParams;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryServiceInterface {
    CategoryReadDTO create(CategoryCreateDTO dto);
    CategoryReadDTO updated(Long id, CategoryUpdateDTO dto);
    void delete(Long id);
    List<CategoryReadDTO> getAll();
    CategoryReadDTO getById(Long id);
    Page<CategoryReadDTO> getPaged(PageRequestParams params);
}
