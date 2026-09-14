package com.codewithemncore.com.sb_ecom.config;

import com.codewithemncore.com.sb_ecom.service.CurrentUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class AuditingConfig {

    private final CurrentUserService currentUserService;

    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return () -> currentUserService.currentUserId();
    }
}
