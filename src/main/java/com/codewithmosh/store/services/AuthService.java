package com.codewithmosh.store.services;

import com.codewithmosh.store.exceptions.UnauthorizedException;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void validateUser(String email, String password) {
        var user = userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            throw new UnauthorizedException();
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException();
        }
    }
}
