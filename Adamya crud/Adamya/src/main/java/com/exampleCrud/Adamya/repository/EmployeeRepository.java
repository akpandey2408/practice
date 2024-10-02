package com.exampleCrud.Adamya.repository; // Defines the package for this interface, helping to organize the project.

import com.exampleCrud.Adamya.model.Employee; // Imports the Employee entity/model class, which will be used in the repository.
import org.springframework.data.jpa.repository.JpaRepository; // Imports JpaRepository, the Spring Data JPA interface for CRUD operations.

// Declares an interface that extends JpaRepository to provide CRUD methods for Employee entities.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
