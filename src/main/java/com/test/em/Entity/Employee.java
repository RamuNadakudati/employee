package com.test.em.Entity;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;

 @Column(name = "first_name", nullable=false)
 private String firstName;

 @Column(name = "last_name", nullable=false)
 private String lastName;

 @Column(name = "email", nullable=false)
 private String email;
 
 @Column(name = "phone_number", nullable=false)
 private String[] phoneNumber;
 
 @Temporal(TemporalType.DATE)
 @Column(name = "doj")
 private Date doj;
 
 @Column(name="salary", nullable=false)
 private Long salary;

}
