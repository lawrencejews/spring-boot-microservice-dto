package com.lawrencejews.employeeservice.service;

import com.lawrencejews.employeeservice.dto.APIResponseDto;
import com.lawrencejews.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
