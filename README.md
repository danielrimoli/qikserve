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

Integration tests are implemented using [Vaadin TestBench](https://vaadin.com/testbench). The tests take a few minutes to run and are therefore included in a separate Maven profile. We recommend running tests with a production build to minimize the chance of development time toolchains affecting test stability. To run the tests using Google Chrome, execute

`mvn verify -Pit,production`

and make sure you have a valid TestBench license installed.

Profile `it` adds the following parameters to run integration tests:
```sh
-Dwebdriver.chrome.driver=path_to_driver
-Dcom.vaadin.testbench.Parameters.runLocally=chrome
```

If you would like to run a separate test make sure you have added these parameters to VM Options of JUnit run configuration

## Project overview

Project follow the Maven's [standard directory layout structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html):
- Under the `src/main/java` are located Application sources
   - `Application.java` is a runnable Java application class and a starting point
   - `MainView.java` is a default view and entry point of the application
- Under the `srs/test` are located test files
- `src/main/resources` contains configuration files and static resources
- The `frontend` directory in the root folder contains client-side dependencies and resource files
   - All CSS styles used by the application are located under the root directory `frontend/styles`    
   - Templates would be stored under the `frontend/src`

## Notes

If you run application from a command line, remember to prepend a `mvn` to the command.
