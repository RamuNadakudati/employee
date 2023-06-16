package com.test.em.controller;

import com.test.em.Response;

import org.springframework.http.ResponseEntity;

/**
 * Response handle base controller.
 */
public class BaseController {
  protected ResponseEntity<Object> buildResponse(Response response) {
    return ResponseEntity.status(response.getStatus()).body(response);
  }
}
