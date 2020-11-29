package com.nayak.starter.domain.common;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class CommonField {
    Instant createAt;
    Instant modifyAt;
    boolean isUsed;
}
