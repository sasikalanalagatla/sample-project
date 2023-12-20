package com.Employee.employeeonboarding.advice;

 public class EmployeeNotFoundException extends RuntimeException {

        public EmployeeNotFoundException(Integer employeeId) {
            super("Employee was not found for parameters {id=" + employeeId + "}");
        }
}
