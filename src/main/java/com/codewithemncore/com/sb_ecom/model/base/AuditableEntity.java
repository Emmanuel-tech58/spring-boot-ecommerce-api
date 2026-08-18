package com.codewithemncore.com.sb_ecom.model.base;

import com.codewithemncore.com.sb_ecom.model.enums.EntityStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@SQLRestriction("status <> 'DELETED'")
public class AuditableEntity extends BaseEntity{
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(updatable = false)
    private Long createdById;

    @LastModifiedBy
    private Long updatedById;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EntityStatus status = EntityStatus.ACTIVE;

    private LocalDateTime statusChangedAt;
    private Long statusChangedById;

    public void changeStatus(EntityStatus newStatus, Long statusChangedById){
        this.status = newStatus;
        this.statusChangedAt = LocalDateTime.now();
        this.statusChangedById = statusChangedById;
    }
}
