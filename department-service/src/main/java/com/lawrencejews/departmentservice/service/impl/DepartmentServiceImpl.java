package com.lawrencejews.departmentservice.service.impl;

import com.lawrencejews.departmentservice.dto.DepartmentDto;
import com.lawrencejews.departmentservice.entity.Department;
import com.lawrencejews.departmentservice.mapper.DepartmentMapper;
import com.lawrencejews.departmentservice.repository.DepartmentRepository;
import com.lawrencejews.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // Convert departmentDto to departmentJPA entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }


}
