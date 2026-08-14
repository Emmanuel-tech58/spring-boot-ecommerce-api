package com.codewithemncore.com.sb_ecom.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
@SQLDelete(sql = "UPDATE #{#entityName} SET deleted_at = NOW(), is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")
public class SoftDeletableEntity extends AuditableEntity{
    private boolean isDeleted = false;
    private LocalDateTime deletedAt;
    private Long deletedById;
}
