package com.codewithemncore.com.sb_ecom.model;

import com.codewithemncore.com.sb_ecom.model.base.SoftDeletableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends SoftDeletableEntity {
    private String name;
}
