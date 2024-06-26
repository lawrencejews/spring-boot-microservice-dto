package com.lawrencejews.employeeservice.service;

import com.lawrencejews.employeeservice.dto.DepartmentDto;
import com.lawrencejews.employeeservice.dto.OrganisationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
    @GetMapping("api/organisations/{code}")
    OrganisationDto getOrganisation(@PathVariable("code") String organisationCode);
}
