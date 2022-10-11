package com.example.employeerecords;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    Employee findByName(String name);


}
