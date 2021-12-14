package com.springboot.fullstack.dao;

import com.springboot.fullstack.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
         public Employee findById(long id);
}
