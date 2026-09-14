package com.codewithemncore.com.sb_ecom;

import com.codewithemncore.com.sb_ecom.config.AppProperties;
import com.codewithemncore.com.sb_ecom.config.CorsProperties;
import com.codewithemncore.com.sb_ecom.config.MailFromProperties;
import com.codewithemncore.com.sb_ecom.config.RabbitMQProperties;
import com.codewithemncore.com.sb_ecom.config.RateLimitProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        AppProperties.class,
        MailFromProperties.class,
        RabbitMQProperties.class,
        CorsProperties.class,
        RateLimitProperties.class
})
public class SbEcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbEcomApplication.class, args);
    }
}
