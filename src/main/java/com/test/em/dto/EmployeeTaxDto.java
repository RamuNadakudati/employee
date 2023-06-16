package com.test.em.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeTaxDto {

private Integer id;
private String firstName;
private String lastName;
private Long yearlySalary;
private float tax;
private float cess;

}