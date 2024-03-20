package com.lawrencejews.employeeservice.service.impl;

import com.lawrencejews.employeeservice.dto.APIResponseDto;
import com.lawrencejews.employeeservice.dto.DepartmentDto;
import com.lawrencejews.employeeservice.dto.EmployeeDto;
import com.lawrencejews.employeeservice.entity.Employee;
import com.lawrencejews.employeeservice.repository.EmployeeRepository;
import com.lawrencejews.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail(),
            employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

    Employee employee = employeeRepository.findById(employeeId).get();
    ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);
    DepartmentDto departmentDto = responseEntity.getBody();



    EmployeeDto employeeDto = new EmployeeDto(
      employee.getId(),
      employee  .getFirstName(),
      employee.getLastName(),
      employee.getEmail(),
      employee.getDepartmentCode()
    );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }

}