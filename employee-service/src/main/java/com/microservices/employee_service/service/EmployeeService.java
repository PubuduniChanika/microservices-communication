package com.microservices.employee_service.service;

import com.microservices.employee_service.dto.ApiResponseDto;
import com.microservices.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeId(Long id);
}
