package com.lawrencejews.employeeservice.repository;

import com.lawrencejews.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
