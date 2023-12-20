package com.Employee.employeeonboarding.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @NotNull(message="User should not be null")
    private String empName;
    @Min(18)
    @Max(50)
    private int age;
    private String designation;
    @NotNull
    @Pattern(regexp = "\\d{10}",message = "invalid mobile number")
    private long mobileNumber;
    @Email(message = "invalid email address")
    private String gmail;

}
