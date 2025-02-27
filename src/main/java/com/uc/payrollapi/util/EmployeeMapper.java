package com.uc.payrollapi.util;
import com.uc.payrollapi.dto.EmployeeDTO;
import com.uc.payrollapi.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail()); //  Ensure email exists in DTO
        employeeDTO.setSalary(employee.getSalary()); //  Ensure salary exists in DTO
        return employeeDTO;
    }

    public Employee toEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail()); //  Ensure email exists in DTO
        employee.setSalary(employeeDTO.getSalary()); //  Ensure salary exists in DTO
        return employee;
    }
}