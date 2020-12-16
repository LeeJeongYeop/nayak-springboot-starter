package com.nayak.starter.utils;

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

    public Cookie getCookie(HttpServletRequest request, String cookieName) {
        final Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie;
            }
        }
        return null;
    }
}
