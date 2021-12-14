package com.springboot.fullstack.service;

import com.springboot.fullstack.dao.EmployeeRepository;
import com.springboot.fullstack.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    
    //create a employee
    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id)
    {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(long id , Employee employeeDetails)
    {
        Employee employee = employeeRepository.findById(id);
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailID(employeeDetails.getEmailID());
        return employeeRepository.save(employee);
    }

    public  ResponseEntity<Map<String, Boolean>> deleteEmployee(long id)
    {
        Employee employee = employeeRepository.findById(id);
        employeeRepository.delete(employee);

        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted"  , Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
