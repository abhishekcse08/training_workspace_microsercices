package com.magnus.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO {

    private EmployeeDto employeeDTO;
    private DepartmentDTO departmentDTO;

}
