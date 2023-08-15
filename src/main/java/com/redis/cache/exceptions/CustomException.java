package com.redis.cache.exceptions;

import com.redis.cache.exceptions.enums.ErrorMessageEnum;

public class CustomException extends Exception {

    public CustomException(final String msgError) {
        super(msgError);
    }

    public CustomException(final String msgError, final ErrorMessageEnum errorMessageEnum) {
        super(msgError + errorMessageEnum);
    }


}
