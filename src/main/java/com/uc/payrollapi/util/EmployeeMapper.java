package com.uc.payrollapi.util;



import com.uc.payrollapi.dto.EmployeeDTO;
import com.uc.payrollapi.model.Employee;


public class EmployeeMapper {

    // Convert Entity → DTO
    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Convert DTO → Entity
    public static Employee toEntity(EmployeeDTO dto) {
        return new Employee(null, dto.getName(), dto.getSalary());
    }
}

