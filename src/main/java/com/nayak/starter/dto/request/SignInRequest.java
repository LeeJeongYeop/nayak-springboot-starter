package com.nayak.starter.dto.request;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SignInRequest {
    String email;
    String password;
}
