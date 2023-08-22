package com.magnus.department.controller;

import com.magnus.department.dto.DepartmentDto;
import com.magnus.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {


private DepartmentService departmentService;

// build saved Dept Rest API

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDept = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code")  String deptCode){
        DepartmentDto savedDept = departmentService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(savedDept, HttpStatus.OK);
    }

}
