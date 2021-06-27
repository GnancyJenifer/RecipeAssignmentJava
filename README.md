# Recipe Application - Java

This application was developed using Java 1.11, Spring Boot, MySQL and Maven 3.8.1.


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the `main` method in the `com.assignment.recipe.RecipeApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Before running the application, Kindly create database and update the username and password in 'application.properties' file and execute the below script in the database.

- /src/main/resources/script.sql

The application runs on https://localhost:8080. I have used basic authentication for accessing rest apis. Please find below the user name and password.

- username: user
- password: pass

For demonstrating the usage of rest api, I have uploaded angular project in the below reppository. Kindly check it.

https://github.com/GnancyJenifer/RecipeAssignmentAngular.git


