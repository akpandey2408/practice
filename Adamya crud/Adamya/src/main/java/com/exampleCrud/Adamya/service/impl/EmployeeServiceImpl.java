package com.exampleCrud.Adamya.service.impl;

//IMPORTING NECESSARY CLASSES AND INTERFACES

//import employee model
import com.exampleCrud.Adamya.model.Employee;
//import target repository for employee
import com.exampleCrud.Adamya.repository.EmployeeRepository;
//import EmployeeService interface
import com.exampleCrud.Adamya.service.EmployeeService;
//import sprinng and other required libraries
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List; //for List operations
import java.util.Optional; // to handle optional objects

//mark this class as service that spring will manage
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired // inject employeerepository dependency
    private EmployeeRepository employeeRepository;

     //save employee in database
     @Override
     public Employee saveEmployee(Employee employee){
        // Call the repository's save method to save all employees
         return employeeRepository.save(employee);
     }

    // get all employee from database
    @Override
    public List<Employee> getAllEmployee() {
        // Call the repository's findAll method to retrieve all employees
        return employeeRepository.findAll();
    }

    // get all employee from the database using id
    @Override
    public Employee getEmployeeById(long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new RuntimeException();
            
    }
    
    }

    // Update an existing employee
    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // Find the employee by id; if not found, throw an exception
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException());
        // Update the existing employee with new details
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save the updated employee back to the database
        employeeRepository.save(existingEmployee);
        // Return the updated employee
        return existingEmployee;
    }

    // delete an employee by id
    @Override
    public void deleteEmployee(long id) {
        // check if the employee exists by id; if not, throw an exception
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException());
        // delete the employee from the database
        employeeRepository.deleteById(id);
    }
}

/*
 * When the controller takes the client request, it will be sent to this service
 * class
 * (service interface — ->ServiceImpl class). Here we need to implement the
 * EmployeeService.
 * java interface (we can only create service a class without service interface
 * if we want).
 * And annotate this EmployeeServiceImple class with the @Service annotation.
 * And according to the request, the Service Implementation class will execute
 * these methods.
 * These are some common logics. Here we need to inject EmployeeRepository
 * interface.
 * For that, use the @Autowired annotation.
 * Using employeeRepository object we can do CRUD operations when we return
 * values.
 */