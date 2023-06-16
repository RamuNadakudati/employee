package com.test.em.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.em.dto.ExceptionDto;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDataException extends RuntimeException{
 private ExceptionDto exceptionDto;
 
 public BadDataException(ExceptionDto exceptionDto) {
   this.exceptionDto = exceptionDto;
 }
}
