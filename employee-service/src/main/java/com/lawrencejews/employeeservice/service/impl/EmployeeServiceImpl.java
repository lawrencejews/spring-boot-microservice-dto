package com.lawrencejews.employeeservice.service.impl;

import com.lawrencejews.employeeservice.dto.APIResponseDto;
import com.lawrencejews.employeeservice.dto.DepartmentDto;
import com.lawrencejews.employeeservice.dto.EmployeeDto;
import com.lawrencejews.employeeservice.dto.OrganisationDto;
import com.lawrencejews.employeeservice.entity.Employee;
import com.lawrencejews.employeeservice.mapper.EmployeeMapper;
import com.lawrencejews.employeeservice.repository.EmployeeRepository;
import com.lawrencejews.employeeservice.service.APIClient;
import com.lawrencejews.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }


    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

    Employee employee = employeeRepository.findById(employeeId).get();

    DepartmentDto departmentDto =  apiClient.getDepartment(employee.getDepartmentCode());

    OrganisationDto organisationDto = apiClient.getOrganisation(employee.getOrganisationCode());



    EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganisation(organisationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {

        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto =  new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }

}
