package com.redis.cache.exceptions;

import com.redis.cache.exceptions.enums.ErrorMessageEnum;

public class CustomException extends Exception {

    protected static final String BASE_COD_ERROR = "#OC%1$d::";

    public CustomException(final String msgError) {
        super(String.format(BASE_COD_ERROR, ErrorMessageEnum.ERROR_INTERNAL.getCod())
                + LocaleContext.format(ErrorMessageEnum.ERROR_INTERNAL.getMessageKey(), msgError));
    }

    public CustomException(final String msgError, final ErrorMessageEnum errorMessageEnum) {
        super(String.format(BASE_COD_ERROR, errorMessageEnum.getCod())
                + LocaleContext.format(errorMessageEnum.getMessageKey(), msgError));
    }


    public CustomException(final ErrorMessageEnum errorMessageEnum, final Object... args) {
        super(String.format(BASE_COD_ERROR, errorMessageEnum.getCod())
                + LocaleContext.format(errorMessageEnum.getMessageKey(), args));
    }
}
