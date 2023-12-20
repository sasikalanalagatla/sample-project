package com.Employee.employeeonboarding.service;
import com.Employee.employeeonboarding.advice.EmployeeNotFoundException;
import com.Employee.employeeonboarding.advice.MobileNumberAlreadyExistException;
import com.Employee.employeeonboarding.dao.EmployeeDao;
import com.Employee.employeeonboarding.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }



    public Employee getEmployeeById(Integer employeeId) {

        return employeeDao.findById(employeeId).orElseThrow(()-> new EmployeeNotFoundException(employeeId));
    }

    public Employee addEmployee(Employee employee) {
        if(employeeDao.existsByMobileNumber(employee.getMobileNumber())){
            throw new MobileNumberAlreadyExistException(employee);
        }
          employeeDao.save(employee);
          return employee;
    }

    public String deleteEmployee(Integer employeeId) {
        employeeDao.deleteById(employeeId);
        return "success";
    }

    public Optional<Employee> getEmployeeByIdNoException(Integer employeeId) {
        return employeeDao.findById(employeeId);
    }

    public Employee createEmployee(@Valid Employee employee) {

        return employeeDao.save(employee);
    }


}





















