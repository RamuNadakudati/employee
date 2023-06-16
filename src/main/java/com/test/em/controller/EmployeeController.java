package com.test.em.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.em.dto.EmployeeDto;
import com.test.em.dto.ResponseDto;
import com.test.em.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends BaseController{

@Autowired
EmployeeService employeeService;

 @PostMapping("/save")
 public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
return buildResponse(employeeService.addEmployee(employeeDto));
 }
 
 @GetMapping("/tax")
 public ResponseEntity<Object> getEmployeesTaxDetails() {
return buildResponse(employeeService.taxDetails());
 }
}

