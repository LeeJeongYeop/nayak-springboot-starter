package com.nayak.starter.utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityUtils {
    public final PasswordEncoder ENCODER = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public String passwordEncode(String password) {
        return ENCODER.encode(password);
    }

    public boolean passwordMatch(String rawPassword, String encodedPassword) {
        return ENCODER.matches(rawPassword, encodedPassword);
    }
}
