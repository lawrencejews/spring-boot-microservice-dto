package com.lawrencejews.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "EmployeeDto Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    @Schema(description = "EmployeeDto  First Name")
    private String firstName;
    @Schema(description = "EmployeeDto  Last Name")
    private String lastName;
    @Schema(description = "EmployeeDto  Email")
    private String email;
    @Schema(description = "EmployeeDto  Department Code")
    private String departmentCode;
    @Schema(description = "EmployeeDto  Organisation Code")
    private String organisationCode;
}
