package com.nayak.starter.dto.request;

import lombok.Value;

@Value
public class SignUpRequest {
    String email;
    String password;
    String role;
    String name;
}
