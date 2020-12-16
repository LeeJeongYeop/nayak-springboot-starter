package com.nayak.starter.utils;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CookieUtils {
    public Cookie createCookie(String cookieName, String value, int maxAge) {
        Cookie token = new Cookie(cookieName, value);
        token.setHttpOnly(true);
        token.setMaxAge(maxAge);
        token.setPath("/");
        // token.setSecure(true);
        return token;
    }

    public Optional<String> getCookieValue(HttpServletRequest request, String cookieName) {
        final Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return Optional.empty();
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return Optional.of(cookie.getValue());
            }
        }

        return Optional.empty();
    }
}
