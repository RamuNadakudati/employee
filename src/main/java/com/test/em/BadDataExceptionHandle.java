package com.test.em;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.em.exception.BadDataException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class BadDataExceptionHandle {
@ExceptionHandler(BadDataException.class)
protected ResponseEntity<Object> handleInvalidAssemblyCodeFormat(BadDataException
badDataException) {
log.error("exceptions Details: {}", badDataException.getExceptionDto());
return ResponseEntity.status(badDataException.getExceptionDto().getStatus())
.body(badDataException.getExceptionDto());
}
}
