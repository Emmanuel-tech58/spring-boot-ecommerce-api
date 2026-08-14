package com.codewithemncore.com.sb_ecom.dto.common;

import org.springframework.data.domain.Sort;

public record PageRequestParams(
        int pageNumber,
        int pageSize,
        String searchTerm,
        String sortBy,
        Sort.Direction sortDirection
) {
    public static PageRequestParams of(int pageNumber, int pageSize, String searchTerm) {
        return new PageRequestParams(pageNumber, pageSize, searchTerm, "id", Sort.Direction.ASC);
    }
}
