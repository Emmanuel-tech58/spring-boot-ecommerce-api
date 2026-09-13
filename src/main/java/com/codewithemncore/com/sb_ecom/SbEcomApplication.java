package com.codewithemncore.com.sb_ecom;

import com.codewithemncore.com.sb_ecom.config.AppProperties;
import com.codewithemncore.com.sb_ecom.repositories.softdeletable.base.SoftDeleteRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(AppProperties.class)
public class SbEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEcomApplication.class, args);
	}

}
