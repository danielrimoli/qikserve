# QikServe Checkout Web App

This is a web-based Checkout system for supermarkets, create as part of the "Home Challenge" for QikServe selection
process.
This project was created using the Vaadin web-app framework with Spring Boot.
It contains all the necessary packages and dependencies to run with a single step


## Running the Application
There are two ways to run the application :  using `mvn spring-boot:run` or by running the `Application` class directly from your IDE.

If you want to run the application locally in the production mode, use `spring-boot:run -Pproduction` command instead.

After the "QikServe Checkout server" if fully initialized, open the "http://localhost:8082" URL in the browser to load
the Checkout web-app.

### Running Integration Tests

Integration tests are implemented using JUnit and Mockito
To run the tests, execute

`mvn test -Put`

## Project overview

Project follow the Maven's [standard directory layout structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html):
- Under the `src/main/java` are located Application sources
   - `Application.java` is a runnable Java application class and a starting point
   - `MainView.java` is a default view and entry point of the application
- Under the `src/test` are located test files
- `src/main/resources` contains configuration files and static resources
- The `frontend` directory in the root folder contains client-side dependencies and resource files
   - All CSS styles used by the application are located under the root directory `frontend/styles`    
   - Templates would be stored under the `frontend/src`

## Notes

If you run application from a command line, remember to prepend a `mvn` to the command.
