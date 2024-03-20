package com.lawrencejews.departmentservice.service;

import com.lawrencejews.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode (String code);
}
