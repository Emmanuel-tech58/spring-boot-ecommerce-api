package com.codewithemncore.com.sb_ecom.repositories.softdeletable.base;

import com.codewithemncore.com.sb_ecom.model.base.AuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SoftDeleteRepository<T extends AuditableEntity, ID> extends JpaRepository<T, ID> {
}
