package com.springboot.fullstack.controller;

import com.springboot.fullstack.model.Employee;
import com.springboot.fullstack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    //create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id)
    {
        return employeeService.getEmployeeById(id);
    }

    //update employee rest api
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id ,@RequestBody Employee employeeDetails)
    {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    //delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String ,  Boolean>> deleteEmployee(@PathVariable long id)
    {
        return employeeService.deleteEmployee(id);

    }
}
