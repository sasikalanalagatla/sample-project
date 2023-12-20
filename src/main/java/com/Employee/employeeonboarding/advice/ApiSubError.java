package com.Employee.employeeonboarding.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiSubError {

    private String string;
    private String field;
    private Object rejectedValue;
    private String message;
}
