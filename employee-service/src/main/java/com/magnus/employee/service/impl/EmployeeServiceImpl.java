package com.magnus.employee.service.impl;

import com.magnus.employee.dto.ApiResponseDTO;
import com.magnus.employee.dto.DepartmentDTO;
import com.magnus.employee.dto.EmployeeDto;
import com.magnus.employee.entity.Employee;
import com.magnus.employee.repository.EmployeeRepository;
import com.magnus.employee.service.APIClient;
import com.magnus.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;
    //private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

          Employee employee =  new Employee(employeeDto.getId(),employeeDto.getFirstName()
                  ,employeeDto.getFirstName(),employeeDto.getEmail(),employeeDto.getDepartmentCode());
          Employee emp = employeeRepository.save(employee);
          EmployeeDto employeeDTO = new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getDepartmentCode());

        return employeeDTO;
    }

    @Override
    public ApiResponseDTO getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Employee emp = employeeOptional.get();

      //  ResponseEntity<DepartmentDTO> forEntity = restTemplate.getForEntity("http://localhost:8081/api/departments/" + emp.getDepartmentCode(), DepartmentDTO.class);
        //    DepartmentDTO departmentDTO = forEntity.getBody();
       /* DepartmentDTO departmentDTO =  webClient.get()
               .uri("http://localhost:8081/api/departments/" + emp.getDepartmentCode())
               .retrieve()
               .bodyToMono(DepartmentDTO.class).block();*/
        DepartmentDTO departmentDTO = apiClient.getDepartment(emp.getDepartmentCode());
        EmployeeDto employeeDto =  new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getDepartmentCode());
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDto);
        apiResponseDTO.setDepartmentDTO(departmentDTO);
        return apiResponseDTO;
    }
}
