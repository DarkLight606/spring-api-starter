package com.codewithmosh.store.config;

import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;

@Configuration
@ConfigurationProperties(prefix = "spring.jwt")
@Data
@Slf4j
public class JwtConfig {
    private String secret;
    private int accessTokenExpiration;
    private int refreshTokenExpiration;

    @PostConstruct
    public void validateConfiguration() {
        if (!StringUtils.hasText(secret)) {
            throw new IllegalStateException("JWT secret must be configured. Please set JWT_SECRET environment variable.");
        }
        
        if (secret.length() < 32) {
            log.warn("JWT secret is shorter than recommended 256 bits (32 characters). Consider using a longer secret for better security.");
        }
        
        log.info("JWT configuration validated successfully");
    }

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
