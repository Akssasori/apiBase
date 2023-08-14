package com.redis.cache.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum {

    ERROR_INTERNAL(01, "email invalido");

    private final int cod;
    private final String messageKey;
}
