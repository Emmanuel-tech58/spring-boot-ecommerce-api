package com.codewithemncore.com.sb_ecom.model;

import com.codewithemncore.com.sb_ecom.model.base.AuditableEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends AuditableEntity<Long> {
    private String name;
}
