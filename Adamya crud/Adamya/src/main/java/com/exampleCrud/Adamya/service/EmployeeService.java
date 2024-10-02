package com.exampleCrud.Adamya.service; // Defines the package (namespace) for the EmployeeService interface.

// Import necessary classes and interfaces
import com.exampleCrud.Adamya.model.Employee; // Import the Employee model class.
import java.util.List; // Import List to handle collections of Employee objects.

// Define the interface for EmployeeService
public interface EmployeeService {

    // Save a new employee to the database
    // Takes an Employee object as input and returns the saved Employee
    Employee saveEmployee(Employee employee);

    // Get a list of all employees from the database
    // Returns a List of Employee objects
    List<Employee> getAllEmployee();

    // Get a single employee by their ID
    // Takes an ID (long) as input and returns the Employee with that ID
    Employee getEmployeeById(long id);

    // Update an existing employee's details using their ID
    // Takes the updated Employee object and the employee ID as input, returns the updated Employee
    Employee updateEmployee(Employee employee, long id);

    // Delete an employee by their ID
    // Takes an ID (long) as input, does not return anything
    void deleteEmployee(long id);
}
