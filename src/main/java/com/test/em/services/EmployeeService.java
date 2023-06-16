package com.test.em.services;
import com.test.em.Response;
import com.test.em.Entity.Employee;
import com.test.em.dto.EmployeeDto;

public interface EmployeeService {

Response addEmployee(EmployeeDto employeeDto);

Response taxDetails();

}
