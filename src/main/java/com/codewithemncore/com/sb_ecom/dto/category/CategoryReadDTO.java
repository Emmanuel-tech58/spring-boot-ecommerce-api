package com.codewithemncore.com.sb_ecom.dto.category;

import javax.lang.model.element.Name;
import java.time.LocalDateTime;

public record CategoryReadDTO(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
