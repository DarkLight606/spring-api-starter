package com.codewithmosh.store.services;

import com.codewithmosh.store.config.JwtConfig;
import com.codewithmosh.store.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class JwtService {
    private final JwtConfig config;

    public String generateAccessToken(User user) {
        return generateToken(user, config.getAccessTokenExpiration());
    }
    public String generateRefreshToken(User user) {
        return generateToken(user, config.getRefreshTokenExpiration());
    }


    private String generateToken(User user, long tokenExpiration) {
        return Jwts.builder()
                .subject(String.valueOf(user.getId()))
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * tokenExpiration))
                .signWith(config.getSecretKey())
                .compact();
    }

    public boolean validateJwtToken(String token) {
        try {
            var claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (JwtException ex) {
            return false;
        }
    }

    public Long getIdFromJwtToken(String token) {
        return Long.valueOf(getClaims(token).getSubject());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(config.getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
