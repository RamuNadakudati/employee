package com.test.em.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class ExceptionDto {
  private String message;
  @JsonIgnore
  private HttpStatus status;
  private Map<String, String> param;

}
