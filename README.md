# demon-sample

Project containing a simple application that runs in the background and send notifications as emails after a certain amount of time.

The back-end to retrieve the notifications has been mocked up.

Requisites
===

The application requires:
* Java 11
* Maven > 3.1
* A Java mail SMTP configuration (not needed in tests) 

Build
===

The application can be build as follows:
```
mvn clean install
```

To build skipping the tests:
```
mvn clean install -DskipTests 
```

Test
===

The tests in the application can be run using:
```
mvn test
```

Run
===

The application uses different profiles files (eg application-dev.properties) which should be configured before running the application.

To run the application using the development properties:

```
java -jar -DSPRING_PROFILES_ACTIVE=dev target/cron-sample-1.0-SNAPSHOT.jar
```
