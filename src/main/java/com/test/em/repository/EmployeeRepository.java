package com.test.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.em.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


}
