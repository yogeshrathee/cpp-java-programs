package com.example.employeerecords;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee)
    {
        employeeService.saveorUpdate(employee);
        return "wow!! Record insert successfully";
    }


    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee employee)
    {
        employeeService.saveorUpdate(employee);
        return "wow!! Record update successfully";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable ("id")int id)
    {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable ("id")int id)
    {
        employeeService.deleteEmployeeById(id);
        return "wow!! Record delete successfully whose id is "+id;
    }
}
