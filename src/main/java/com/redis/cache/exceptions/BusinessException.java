package com.redis.cache.exceptions;

import com.redis.cache.exceptions.enums.ErrorMessageEnum;

public class BusinessException extends CustomException {

    public BusinessException(final String msgError, final ErrorMessageEnum errorMessageEnum) {
        super(msgError, errorMessageEnum);
    }

    public BusinessException(final String msgError) {
        super(msgError, ErrorMessageEnum.ERROR_BUSINESS);
    }

    public BusinessException(final ErrorMessageEnum errorMessageEnum, final Object... args) {
        super(errorMessageEnum, args);
    }
}
