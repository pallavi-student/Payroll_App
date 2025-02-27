package com.uc.payrollapi.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required and cannot be empty.")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name can only contain letters and spaces.")
    private String name;

    @NotBlank(message = "Email is required.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$",
            message = "Invalid email format.")
    private String email;

    private Double salary;
}
