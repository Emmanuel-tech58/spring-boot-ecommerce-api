package com.codewithemncore.com.sb_ecom.config;

import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "app.rate-limit")
@Validated
public record RateLimitProperties(
        /** Maximum requests allowed within the refill period */
        @Min(1) int capacity,
        /** Number of tokens refilled per period */
        @Min(1) int refillTokens,
        /** Refill period in seconds */
        @Min(1) long refillPeriodSeconds
) {}
