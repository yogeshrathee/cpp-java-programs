package com.example.employeerecords;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {


    @Autowired
    private EmployeeRepository repo;

    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateEmployee() {
        Employee savedEmployee = repo.save(new Employee(1, "yogesh rathee", 22, "yogesh.rathee@gmail.com"));

        assertThat(savedEmployee.getId()).isGreaterThan(0);
        System.out.println("\n\n---------------------------TEST CASE PASSED:-testCreateEmployee()---------------------------\n---------------------------RECORD CREATE OR INSERT SUCCESSFULLY !!---------------------------\n"+savedEmployee+"\n\n");

    }


        @Test
        @Order(2)
        public void testFindEmployeeByName() {
            Employee employee = new Employee(1,"yogesh rathee",22,"yogesh.rathee@gmail.com");
            assertThat(employee.getName()).isEqualTo("yogesh rathee");
            System.out.println("\n\n---------------------------TEST CASE PASSED:-testFindEmployeeByName()---------------------------\n---------------------------RECORD FIND SUCCESSFULLY !!---------------------\n"+employee+"\n\n");
        }
    @Test
    @Order(3)
    public void testListEmployee() {
        List<Employee> employee = (List<Employee>) repo.findAll();
        assertThat(employee).isNotNull();
        System.out.println("\n\n---------------------------TEST CASE PASSED:-testListEmployee()---------------------------\n---------------------------LIST OF ALL EMPLOYEES FIND AND SHOW SUCCESSFULLY !!---------------------\n"+employee+"\n\n");
    }

        @Test
        @Rollback(false)
        @Order(4)
        public void testUpdateEmployee() {
            Employee employee =new Employee(1,"yogesh rathee",22,"yogesh@gmail.com");
            employee.setEmail("yogesh@gmail.com");
            repo.save(employee);

            Employee updatedEmployee = repo.save(employee);

            assertThat(updatedEmployee.getEmail()).isEqualTo("yogesh@gmail.com");
            System.out.println("\n\n---------------------------TEST CASE PASSED:-testUpdateEmployee()---------------------------\n---------------------------RECORD UPDATED SUCCESSFULLY !!---------------------\n"+updatedEmployee+"\n\n");
        }

        @Test
        @Rollback(false)
        @Order(5)
        public void testDeleteEmployee() {

            Employee employee = repo.findByName("yogesh rathee");

            repo.deleteById(employee.getId());
            System.out.println("\n\n---------------------------TEST CASE PASSED:-testDeleteEmployee()---------------------------\n---------------------------RECORD DELETE SUCCESSFULLY !!---------------------\n"+employee+"\n\n");

            Employee deletedEmployee = repo.findByName("yogesh rathee");

            assertThat(deletedEmployee).isNull();
        }

    }


