package com.magnus.employee.controller;

import com.magnus.employee.dto.ApiResponseDTO;
import com.magnus.employee.dto.EmployeeDto;
import com.magnus.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto>  saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDTO = employeeService.saveEmployee(employeeDto);
        return  new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDTO>  getEmployee(@PathVariable("id") Long employeeId){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeeById(employeeId);
        return  new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }


}
