package com.test.em.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

private Integer id;
@NotNull(message =" First name cannot be null")
private String firstName;
@NotNull(message =" Last name cannot be null")
private String lastName;
@NotNull(message =" Email cannot be null")
private String email;
@NotNull(message =" Phone Number cannot be null")
private String[] phoneNumber;
@NotNull(message =" DoJ cannot be null")
private Date doj;
@NotNull(message =" Salary cannot be null")
private Long salary;


}

