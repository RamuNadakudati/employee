package com.test.em;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class Response {
 
  @JsonIgnore
  private HttpStatus status;
  private Object responseBody;
}
