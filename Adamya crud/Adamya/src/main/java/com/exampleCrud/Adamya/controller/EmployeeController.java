package com.exampleCrud.Adamya.controller;

// Import necessary classes and interfaces
import com.exampleCrud.Adamya.model.Employee; // Import the Employee model
import com.exampleCrud.Adamya.service.EmployeeService; // Import the EmployeeService interface
import org.springframework.beans.factory.annotation.Autowired; // To enable dependency injection
import org.springframework.http.HttpStatus; // For specifying HTTP status codes
import org.springframework.http.ResponseEntity; // To wrap the response with an HTTP status
import org.springframework.web.bind.annotation.*; // Required for Spring REST APIs (Get, Post, etc.)

import java.util.List; // To handle lists of employees

// Mark this class as a REST controller to handle HTTP requests
@RestController
// Define the base URL for this controller
@RequestMapping("/api/employees")
public class EmployeeController {

    // Autowire the EmployeeService so that we can call the service layer from this
    // controller
    @Autowired
    private EmployeeService employeeService;

    // POST API: Save a new employee to the database
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        // Calls the service layer to save the employee and returns a ResponseEntity
        // with HTTP status CREATED
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // GET API: Get all employees from the database
    @GetMapping
    public List<Employee> getAllEmployee() {
        // Calls the service layer to fetch all employees and return them as a list
        return employeeService.getAllEmployee();
    }

    // GET API: Get a specific employee by their ID
    @GetMapping("{id}")
    // The {id} is a path variable 
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeID) {
        // Calls the service layer to fetch the employee by ID and return it with HTTP
        // status OK
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeID), HttpStatus.OK);
    }

    // PUT API: Update an existing employee's details by their ID
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        // Calls the service layer to update the employee and return the updated
        // employee with HTTP status OK
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    // DELETE API: Delete an employee by their ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
        // Calls the service layer to delete the employee from the database
        employeeService.deleteEmployee(id);
        // Returns a confirmation message with HTTP status OK
        return new ResponseEntity<String>("Employee deleted Successfully.", HttpStatus.OK);
    }
}
