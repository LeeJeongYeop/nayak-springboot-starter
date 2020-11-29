package com.nayak.starter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class UserInfoResponse {
    String email;
    String name;
}
