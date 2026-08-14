package com.codewithemncore.com.sb_ecom.repositories.specification;

import com.codewithemncore.com.sb_ecom.model.Category;
import org.springframework.data.jpa.domain.Specification;

public class CategorySpecification {
    public static Specification<Category> isActive(){
        return (root, query, cb) -> cb.isFalse(root.get("isDeleted"));
    }

    public static Specification<Category> nameContains(String term){
        if(term == null || term.isBlank()) return null;
        String like = "%" + term.toLowerCase() + "%";
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), like);
    }
}
