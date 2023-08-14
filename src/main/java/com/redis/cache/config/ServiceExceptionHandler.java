package com.redis.cache.config;

import com.redis.cache.dto.ErrorResponseDTO;
import com.redis.cache.exceptions.TesteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TesteException.class)
    public final ResponseEntity<ErrorResponseDTO> handleResponseException(Exception ex, WebRequest request) {

        ErrorResponseDTO responseDTO = ErrorResponseDTO.builder()
                .date(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
        System.out.println("****request****" + request);
        return new ResponseEntity<>(responseDTO,HttpStatus.CONFLICT);


    }
}
