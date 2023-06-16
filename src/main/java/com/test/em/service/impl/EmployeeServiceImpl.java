package com.test.em.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.em.Response;
import com.test.em.Entity.Employee;
import com.test.em.dto.EmployeeDto;
import com.test.em.dto.EmployeeTaxDto;
import com.test.em.dto.ExceptionDto;
import com.test.em.exception.BadDataException;
import com.test.em.repository.EmployeeRepository;
import com.test.em.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

@Autowired
EmployeeRepository empRepository;


@Override
public Response addEmployee(EmployeeDto employee) {
Response.ResponseBuilder result =  Response.builder();
   result.status(HttpStatus.BAD_REQUEST);
    if(validtePhoneNumbers(employee.getPhoneNumber())) {
    ObjectMapper mapper = new ObjectMapper();
       mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Employee emp = mapper.convertValue(employee, Employee.class);
    emp = empRepository.save(emp);
    result.responseBody(emp);
    result.status(HttpStatus.OK);
    } else {
    throw new BadDataException(ExceptionDto.builder().message("Please add atleast one phone number").status(HttpStatus.BAD_REQUEST).build());
    }
   
   return result.build();
}


public boolean validtePhoneNumbers(String[] phoneNumbers) {
if(phoneNumbers.length > 0) {
return Boolean.TRUE;
}
return Boolean.FALSE;
}
public Employee transformEmployee(EmployeeDto employeeDto) {
Employee employee = new Employee();
employee.setPhoneNumber(employeeDto.getPhoneNumber());
employee.setDoj(employeeDto.getDoj());
employee.setEmail(employeeDto.getEmail());
employee.setFirstName(employeeDto.getFirstName());
employee.setLastName(employeeDto.getLastName());
employee.setSalary(employeeDto.getSalary());
return employee;
}


@Override
public Response taxDetails() {
Response.ResponseBuilder result =  Response.builder();
   
   List<Employee> empList = empRepository.findAll();
   List<EmployeeTaxDto> responseList = new ArrayList<>();
   for(Employee emp : empList) {
    EmployeeTaxDto taxDto = new EmployeeTaxDto();
    taxDto.setId(emp.getId());
    taxDto.setFirstName(emp.getFirstName());
    taxDto.setLastName(emp.getLastName());
    int monthsWorked = getMonthsWorked(emp.getDoj());
    long yearSalary = monthsWorked * emp.getSalary();
    taxDto.setYearlySalary(yearSalary);
    if(yearSalary <= 250000) {
    taxDto.setTax(0);
    } else if (yearSalary >2500000 && yearSalary <= 500000) {
    float tax = (yearSalary * 5)/100;
    taxDto.setTax(tax);
    } else if(yearSalary > 500000 && yearSalary <= 1000000 ) {
    float tax = (yearSalary * 10)/100;
    taxDto.setTax(tax);
    } else {
    float tax = (yearSalary * 20)/100;
    taxDto.setTax(tax);
    }
    if(yearSalary > 2500000) {
    long diff = yearSalary - 2500000;
    float cess = (diff * 2)/100;
    taxDto.setCess(cess);
    }
    responseList.add(taxDto);
   }
   result.status(HttpStatus.OK);
result.responseBody(responseList);
return result.build();
}

private int getMonthsWorked(Date dateOfJoining) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfJoining);

        calendar.set(Calendar.MONTH, Calendar.APRIL);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        if (calendar.get(Calendar.MONTH) < Calendar.APRIL) {
            calendar.add(Calendar.YEAR, 1);
        }

        Calendar currentCalendar = Calendar.getInstance();
        int monthsWorked = 0;
        while (calendar.before(currentCalendar)) {
            if (calendar.get(Calendar.MONTH) != Calendar.APRIL) {
                monthsWorked++;
            }
            calendar.add(Calendar.MONTH, 1);
        }

        return monthsWorked;
}
}


