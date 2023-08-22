package com.magnus.employee.service;

import com.magnus.employee.dto.ApiResponseDTO;
import com.magnus.employee.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDTO getEmployeeById(Long employeeId);
}
