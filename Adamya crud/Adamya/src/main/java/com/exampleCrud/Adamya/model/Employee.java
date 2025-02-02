package com.exampleCrud.Adamya.model; // Defines the package for the Employee class (namespace).

// Import necessary annotations from Jakarta Persistence (JPA) and Lombok libraries.
import jakarta.persistence.*; // Imports JPA annotations for defining the entity and its properties in the database.
import lombok.AllArgsConstructor; // Generates a constructor with all fields as parameters.
import lombok.Data; // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods.
import lombok.NoArgsConstructor; // Generates a no-arguments constructor.

// Mark this class as a JPA entity that will map to a database table.
@Entity
// Lombok annotation to automatically generate a constructor with all parameters.
@AllArgsConstructor
// Lombok annotation to automatically generate a no-argument constructor.
@NoArgsConstructor
// Lombok annotation to generate boilerplate methods like getters, setters, and toString.
@Data
// Maps the entity to the "employees" table in the database.
@Table(name = "employees")
public class Employee {

    // Marks this field as the primary key of the table.
    @Id
    // Specifies that the ID will be auto-generated by the database (usually using an auto-increment strategy).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // The primary key for the employee, auto-incremented.

    // Maps this field to the "first_name" column in the database.Marks the column as non-nullable, meaning this field must be provided.
    @Column(name = "first_name", nullable = false)
    private String firstName; // Employee's first name.

    // Maps this field to the "last_name" column in the database. Also marked as non-nullable.
    @Column(name = "last_name", nullable = false)
    private String lastName; // Employee's last name.

    // Maps this field to the "email_id" column in the database.Marked as non-nullable to ensure that an email is always provided.
    @Column(name = "email_id", nullable = false)
    private String email; // Employee's email address.
}
