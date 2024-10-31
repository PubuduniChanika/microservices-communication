package com.microservices.department_service.service.impl;

import com.microservices.department_service.dto.DepartmentDto;
import com.microservices.department_service.entity.Department;
import com.microservices.department_service.repository.DepartmentRepository;
import com.microservices.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(savedDepartment.getId(), savedDepartment.getDepartmentName(), savedDepartment.getDepartmentDescription(), savedDepartment.getDepartmentCode());
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto DepartmentDto = new DepartmentDto(department.getId(), department.getDepartmentName(), department.getDepartmentDescription(), department.getDepartmentCode());
        return DepartmentDto;
    }
}
