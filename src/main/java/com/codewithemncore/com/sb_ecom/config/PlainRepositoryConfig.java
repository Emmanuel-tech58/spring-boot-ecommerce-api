package com.codewithemncore.com.sb_ecom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.codewithemncore.com.sb_ecom.repositories.plain"
        // no repositoryBaseClass — uses the default SimpleJpaRepository
)
public class PlainRepositoryConfig {
}
