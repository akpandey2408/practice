package com.exampleCrud.Adamya; // Defines the package for this class (namespace).

// Import necessary classes from the Spring framework
import org.springframework.boot.SpringApplication; // This class is used to bootstrap and launch the Spring application.
import org.springframework.boot.autoconfigure.SpringBootApplication; // This annotation enables Spring Boot's auto-configuration and component scanning.

// Marks this class as the entry point of the Spring Boot application
@SpringBootApplication
public class AdamyaApplication {

	// The main method: Entry point for the Java application
	public static void main(String[] args) {
		// This line boots the Spring application, starting the embedded server (Tomcat
		// by default) and setting up the application context
		SpringApplication.run(AdamyaApplication.class, args);

		// This line prints a message to the console, indicating that the server has
		// started
		System.out.println("Server is running");
	}

}
